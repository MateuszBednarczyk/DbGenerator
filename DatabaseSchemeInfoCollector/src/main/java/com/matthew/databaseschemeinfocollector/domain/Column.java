package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
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

}
