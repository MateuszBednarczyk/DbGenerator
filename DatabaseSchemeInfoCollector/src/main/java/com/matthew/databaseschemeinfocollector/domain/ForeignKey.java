package com.matthew.databaseschemeinfocollector.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ForeignKey {
    private Column source;
    private Column relatedTo;
}
