package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class Column {

    @NotBlank
    @Getter
    private final String name;

    @NotBlank
    @Getter
    private final ColumnType columnType;

    @NotBlank
    private Integer size;

    public Column(String name, ColumnType columnType) {
        this.name = name;
        this.columnType = columnType;
    }
}
