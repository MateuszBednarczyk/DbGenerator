package com.matthew.databaseschemeinfocollector.query;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;

import java.util.List;

public interface TableQuery {

    String generateCreateTableQuery(final List<CreateTableDTO> dtos);

}
