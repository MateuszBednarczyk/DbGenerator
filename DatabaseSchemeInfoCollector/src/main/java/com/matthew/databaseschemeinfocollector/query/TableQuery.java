package com.matthew.databaseschemeinfocollector.query;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;

public interface TableQuery {

    String generateCreateTableQuery(CreateTableDTO dto);

}
