package com.matthew.databaseschemeinfocollector.dto;

public record ForeignKeyDTO(
        String foreignKeyName,
        ColumnDTO source,
        String sourceColumnType,
        String sourceTableName,
        ColumnDTO relatedTo,
        String relatedToColumnType,
        String relatedToTableName
) {
}
