package com.matthew.databaseschemeinfocollector.dto;

public record ForeignKeyDTO(
        ColumnDTO source,
        ColumnDTO relatedTo
) {
}
