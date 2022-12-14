package com.matthew.databaseschemeinfocollector.query;

import com.matthew.databaseschemeinfocollector.domain.Column;
import com.matthew.databaseschemeinfocollector.domain.ColumnType;
import com.matthew.databaseschemeinfocollector.domain.ForeignKey;
import com.matthew.databaseschemeinfocollector.domain.Table;
import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;
import com.matthew.databaseschemeinfocollector.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.matthew.databaseschemeinfocollector.exception.CustomExceptionMessage.INVALID_COLUMN_TYPE;

@Component
@AllArgsConstructor
@Slf4j
public class TableQueryImpl implements TableQuery {

    @Override
    public String generateCreateTableQuery(final List<CreateTableDTO> dtos) {
        StringBuilder query = new StringBuilder();
        dtos.forEach(tableDTO -> {
            Set<Column> columns = getColumnsFromDTO(tableDTO);
            Set<ForeignKey> foreignKeys = getForeignKeysFromDTO(tableDTO);

            Column primaryKey = Column.builder()
                    .name("ID")
                    .columnType(getColumnTypeForPrimaryKey(tableDTO.primaryKeyColumnType()))
                    .build();

            Table table = new Table.Builder()
                    .name(tableDTO.name())
                    .primaryKey(primaryKey)
                    .columns(columns)
                    .foreignKeys(foreignKeys)
                    .build();

            query.append(generateCreateTableQueryPart(table));
            query.append(generateColumnsQueryPart(table));
            query.append(");");

            generateForeignKeysQuery(query, table);
            log.info(query.toString());
        });
        return query.toString();
    }

    private String generateColumnsQueryPart(Table table) {
        StringBuilder query = new StringBuilder();
        table.getColumns().forEach(column -> {
            query.append(", " + column.getName());
            switch (column.getColumnType()) {
                case INT -> query.append(" INT");
                case UUID -> query.append(" UUID");
                case VARCHAR -> query.append(" VARCHAR (" + column.getSize() + ")");
                default -> throw new CustomException(HttpStatus.BAD_REQUEST, INVALID_COLUMN_TYPE);
            }
        });
        return query.toString();
    }

    private ColumnType getColumnTypeForPrimaryKey(String stringValueOfType) {
        switch (stringValueOfType) {
            case "UUID" -> {
                return ColumnType.UUID;
            }
            case "INT" -> {
                return ColumnType.INT;
            }
        }
        throw new CustomException(HttpStatus.BAD_REQUEST, INVALID_COLUMN_TYPE);
    }

    private Set<Column> getColumnsFromDTO(CreateTableDTO tableDTO) {
        Set<Column> columns = new HashSet<>();
        tableDTO.columns().forEach(columnDTO -> {
            columns.add(Column.builder()
                    .name(columnDTO.name())
                    .columnType(ColumnType.valueOf(columnDTO.columnType()))
                    .size(columnDTO.size())
                    .build());
        });
        return columns;
    }

    private Set<ForeignKey> getForeignKeysFromDTO(CreateTableDTO tableDTO) {
        Set<ForeignKey> foreignKeys = new HashSet<>();
        tableDTO.foreignKeys().forEach(foreignKeyDTO -> {
            Column source = Column.builder()
                    .name(foreignKeyDTO.source().name())
                    .columnType(ColumnType.valueOf(foreignKeyDTO.relatedToColumnType()))
                    .size(foreignKeyDTO.sourceColumnLength())
                    .build();

            Column relatedTo = Column.builder()
                    .name(foreignKeyDTO.relatedTo().name())
                    .columnType(ColumnType.valueOf(foreignKeyDTO.relatedToColumnType()))
                    .size(foreignKeyDTO.relatedToColumnSize())
                    .build();

            foreignKeys.add(ForeignKey.builder()
                    .foreignKeyName(foreignKeyDTO.foreignKeyName())
                    .source(source)
                    .sourceTableName(foreignKeyDTO.sourceTableName())
                    .relatedTo(relatedTo)
                    .relatedToTableName(foreignKeyDTO.relatedToTableName())
                    .build());
        });
        return foreignKeys;
    }

    private void generateForeignKeysQuery(StringBuilder query, Table table) {
        table.getForeignKeys().forEach(foreignKey -> {
            query
                    .append("ALTER TABLE ")
                    .append(table.getName())
                    .append(" ADD CONSTRAINT ")
                    .append(foreignKey.getForeignKeyName())
                    .append(" FOREIGN KEY (")
                    .append(foreignKey.getSource().getName())
                    .append(") REFERENCES ")
                    .append(foreignKey.getRelatedToTableName())
                    .append(" (")
                    .append(foreignKey.getRelatedTo().getName())
                    .append(")");
        });
    }

    private String generateCreateTableQueryPart(Table table) {
        return "CREATE TABLE " +
                "\"" +
                table.getName() +
                "\" " +
                "(" +
                table.getPrimaryKey().getName() + " " + table.getPrimaryKey().getColumnType() + " PRIMARY KEY";
    }

}
