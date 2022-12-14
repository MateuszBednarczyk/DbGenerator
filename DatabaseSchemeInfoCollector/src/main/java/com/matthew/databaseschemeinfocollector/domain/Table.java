package com.matthew.databaseschemeinfocollector.domain;

import java.util.HashSet;

public class Table {
    private String name;
    private Column primaryKey;
    private HashSet<Column> columns = new HashSet<>();
    private HashSet<ForeignKey> foreignKeys = new HashSet<>();

    public Table(String name, HashSet<Column> columns, HashSet<ForeignKey> foreignKeys) {
        this.name = name;
        this.primaryKey = new Column("ID");
        this.columns = columns;
        this.foreignKeys = foreignKeys;
    }
}
