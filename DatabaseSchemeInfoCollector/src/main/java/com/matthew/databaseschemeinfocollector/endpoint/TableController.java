package com.matthew.databaseschemeinfocollector.endpoint;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;
import com.matthew.databaseschemeinfocollector.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/table")
@AllArgsConstructor
public class TableController {

    private final TableService tableService;

    @PostMapping
    public void createNewTable(final @RequestBody CreateTableDTO dto) {
        tableService.createTable(dto);
    }

}
