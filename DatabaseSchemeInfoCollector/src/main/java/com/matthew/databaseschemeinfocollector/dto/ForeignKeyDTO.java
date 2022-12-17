package com.matthew.databaseschemeinfocollector.dto;

public record ForeignKeyDTO(
        ColumnDTO source,
        String sourceColumnType,
        ColumnDTO relatedTo,
        String relatedToColumnType
) {
}
