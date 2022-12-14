package com.matthew.databaseschemeinfocollector.domain;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Scheme {
    private String name;
    private List<Table> tables = new ArrayList<>();
}
