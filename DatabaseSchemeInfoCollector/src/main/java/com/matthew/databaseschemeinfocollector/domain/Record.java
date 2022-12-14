package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class Record {

    @NotBlank
    private Long id;

    @NotBlank
    private HashMap<String, String> values = new HashMap<>();

}
