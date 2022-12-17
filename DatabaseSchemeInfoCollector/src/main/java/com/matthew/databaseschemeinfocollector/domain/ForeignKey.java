package com.matthew.databaseschemeinfocollector.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ForeignKey {

    @NotBlank
    private String foreignKeyName;

    @NotBlank
    private Column source;

    @NotBlank
    private String sourceTableName;

    @NotBlank
    private Column relatedTo;

    @NotBlank
    private String relatedToTableName;

}
