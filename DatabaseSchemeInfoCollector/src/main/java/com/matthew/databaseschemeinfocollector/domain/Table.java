package com.matthew.databaseschemeinfocollector.domain;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Table {

    @NotBlank
    @Getter
    private final String name;

    @NotBlank
    @Getter
    private final Column primaryKey;

    @NotBlank
    @Getter
    private Set<Column> columns = new HashSet<>();

    @NotBlank
    @Getter
    private Set<ForeignKey> foreignKeys = new HashSet<>();

    public Table(String name, Set<Column> columns, Set<ForeignKey> foreignKeys) {
        this.name = name;
        this.primaryKey = new Column("ID", ColumnType.INT);
        this.columns = columns;
        this.foreignKeys = foreignKeys;
    }
}
