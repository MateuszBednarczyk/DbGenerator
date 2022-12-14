package com.matthew.databaseschemeinfocollector.domain;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class Record {
    private Long id;
    private HashMap<String, String> values = new HashMap<>();
}
