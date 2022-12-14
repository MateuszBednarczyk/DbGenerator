package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Scheme {

    @NotBlank
    private String name;

    @NotBlank
    private List<Table> tables = new ArrayList<>();
}
