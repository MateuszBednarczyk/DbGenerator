package com.matthew.databaseschemeinfocollector.dto;

import java.util.Set;

public record CreateTableDTO(
        String name,
        ColumnDTO primaryKey,
        Set<String> columns,
        Set<ForeignKeyDTO> foreignKeys
) {
}
