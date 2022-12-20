package com.matthew.databaseschemeinfocollector.dto;

import com.matthew.databaseschemeinfocollector.domain.ColumnType;

import java.util.Set;

public record CreateTableDTO(
        String name,
        Set<ColumnDTO> columns,
        Set<ForeignKeyDTO> foreignKeys,
        String primaryKeyColumnType
) {
}
