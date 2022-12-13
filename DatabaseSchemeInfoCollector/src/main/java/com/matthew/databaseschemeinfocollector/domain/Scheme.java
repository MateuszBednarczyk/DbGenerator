package com.matthew.databaseschemeinfocollector.domain;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Scheme {
    private String name;
    private List<Entity> entities = new ArrayList<>();
    private List<Relation> relations = new ArrayList<>();
}
