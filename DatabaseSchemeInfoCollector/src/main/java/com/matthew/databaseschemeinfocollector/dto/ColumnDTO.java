package com.matthew.databaseschemeinfocollector.dto;

public record ColumnDTO(
        String name,
        String columnType,
        Integer size
) {
}
