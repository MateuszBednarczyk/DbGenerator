package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ForeignKey {

    @NotBlank
    private Column source;

    @NotBlank
    private Column relatedTo;

}
