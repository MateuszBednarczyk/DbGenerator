package com.matthew.databaseschemeinfocollector.dto;

import java.util.Set;

public record CreateTableDTO(
        String name,
        Set<ColumnDTO> columns,
        Set<ForeignKeyDTO> foreignKeys
) {
}
