package com.matthew.databaseschemeinfocollector.domain;


import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

public class Table {
    @NotBlank
    private String name;

    @NotBlank
    private Column primaryKey;

    @NotBlank
    private Set<Column> columns = new HashSet<>();

    @NotBlank
    private Set<ForeignKey> foreignKeys = new HashSet<>();

    public Table(String name, Set<Column> columns, Set<ForeignKey> foreignKeys) {
        this.name = name;
        this.primaryKey = new Column("ID");
        this.columns = columns;
        this.foreignKeys = foreignKeys;
    }
}
