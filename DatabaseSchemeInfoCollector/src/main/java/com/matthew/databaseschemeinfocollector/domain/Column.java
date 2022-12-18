package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Column {

    @NotBlank
    @Getter
    private final String name;

    @NotBlank
    @Getter
    private final ColumnType columnType;

    @NotBlank
    @Getter
    private Integer size;

    public Column(String name, ColumnType columnType) {
        this.name = name;
        this.columnType = columnType;
    }
}
