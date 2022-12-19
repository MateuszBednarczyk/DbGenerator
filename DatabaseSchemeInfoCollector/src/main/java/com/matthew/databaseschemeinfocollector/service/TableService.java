package com.matthew.databaseschemeinfocollector.service;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;

import java.util.List;

public interface TableService {
    void createTable(List<CreateTableDTO> dtos);
}
