package com.matthew.databaseschemeinfocollector.query;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class TableQueryImpl implements TableQuery {

    @Override
    public String generateCreateTableQuery(CreateTableDTO dto) {
        String query = "CREATE TABLE " + "\"" + dto.name() + "\"" + "();";
        log.info(query);
        return query;
    }

}
