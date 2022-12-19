package com.matthew.databaseschemeinfocollector.query;

import com.matthew.databaseschemeinfocollector.domain.Column;
import com.matthew.databaseschemeinfocollector.domain.ColumnType;
import com.matthew.databaseschemeinfocollector.domain.ForeignKey;
import com.matthew.databaseschemeinfocollector.domain.Table;
import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class TableQueryImpl implements TableQuery {

    @Override
    public String generateCreateTableQuery(final List<CreateTableDTO> dtos) {
        StringBuilder query = new StringBuilder();
        dtos.forEach(tableDTO -> {
            Set<Column> columns = new HashSet<>();
            Set<ForeignKey> foreignKeys = new HashSet<>();

            tableDTO.columns().forEach(columnDTO -> {
                columns.add(new Column(columnDTO.name(), ColumnType.valueOf(columnDTO.columnType()), columnDTO.size()));
            });

            tableDTO.foreignKeys().forEach(foreignKeyDTO -> {
                Column source = new Column(foreignKeyDTO.source().name(),
                        ColumnType.valueOf(foreignKeyDTO.relatedToColumnType()), foreignKeyDTO.sourceColumnLength());
                Column relatedTo = new Column(foreignKeyDTO.relatedTo().name(),
                        ColumnType.valueOf(foreignKeyDTO.sourceColumnType()), foreignKeyDTO.relatedToColumnSize());
                foreignKeys.add(new ForeignKey(foreignKeyDTO.foreignKeyName(), source, foreignKeyDTO.sourceTableName(),
                        relatedTo, foreignKeyDTO.relatedToTableName()));
            });

            Table table = new Table(tableDTO.name(), columns, foreignKeys);

            query.append("CREATE TABLE ");
            query.append("\"");
            query.append(table.getName());
            query.append("\" ");
            query.append("(");
            query.append(table.getPrimaryKey().getName() + " " + table.getPrimaryKey().getColumnType() + " PRIMARY KEY");

            table.getColumns().forEach(column -> {
                query.append(", " + column.getName());
                switch (column.getColumnType()) {
                    case INT -> query.append(" INT");
                    case VARCHAR -> query.append(" VARCHAR (" + column.getSize() + ")");
                    default -> throw new RuntimeException("invalid column type");
                }
            });
            query.append("); ");

            table.getForeignKeys().forEach(foreignKey -> {
                query.append("ALTER TABLE " + table.getName() + " ADD CONSTRAINT " + foreignKey.getForeignKeyName() +
                        " FOREIGN KEY (" + foreignKey.getSource().getName() + ") REFERENCES " +
                        foreignKey.getRelatedToTableName() + " (" + foreignKey.getRelatedTo().getName() + ")");
            });
            log.info(query.toString());
        });
        return query.toString();
    }

}
