package com.matthew.databaseschemeinfocollector.domain;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Table {

    @NotBlank
    @Getter
    private String name;

    @NotBlank
    @Getter
    private Column primaryKey;

    @NotBlank
    @Getter
    private Set<Column> columns = new HashSet<>();

    @NotBlank
    @Getter
    private Set<ForeignKey> foreignKeys = new HashSet<>();

    public static final class Builder {

        private String name;
        private Column primaryKey;
        private Set<Column> columns = new HashSet<>();
        private Set<ForeignKey> foreignKeys = new HashSet<>();

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder primaryKey(Column primaryKey){
            this.primaryKey = primaryKey;
            return this;
        }

        public Builder columns(Set<Column> columns){
            this.columns = columns;
            return this;
        }

        public Builder foreignKeys(Set<ForeignKey> foreignKeys){
            this.foreignKeys = foreignKeys;
            return this;
        }

        public Table build (){
            Table table = new Table();
            table.name = this.name;
            table.primaryKey = this.primaryKey;
            table.columns = this.columns;
            table.foreignKeys = this.foreignKeys;
            return table;
        }
    }
}
