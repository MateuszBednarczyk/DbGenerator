package com.matthew.databaseschemeinfocollector.endpoint;

import com.matthew.databaseschemeinfocollector.dto.CreateTableDTO;
import com.matthew.databaseschemeinfocollector.service.TableService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/table")
@AllArgsConstructor
@Validated
public class TableController {

    private final TableService tableService;

    @PostMapping
    public void createNewTable(@Valid final @RequestBody List<CreateTableDTO> dtos) {
        tableService.createTable(dtos);
    }

}
