package com.matthew.databaseschemeinfocollector.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record CreateTableDTO(

        @NotBlank(message = "Name cannot be blank")
        String name,

        Set<ColumnDTO> columns,
        Set<ForeignKeyDTO> foreignKeys,

        @NotBlank(message = "Primary column type cannot be blank")
        String primaryKeyColumnType
) {
}
