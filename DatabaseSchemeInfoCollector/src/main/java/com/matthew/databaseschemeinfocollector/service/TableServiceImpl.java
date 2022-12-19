package com.matthew.databaseschemeinfocollector.service;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;
import com.matthew.databaseschemeinfocollector.query.TableQuery;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TableServiceImpl implements TableService {

    private final TableQuery tableQuery;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createTable(final List<CreateTableDTO> dtos) {
        jdbcTemplate.execute(tableQuery.generateCreateTableQuery(dtos));
    }
}
