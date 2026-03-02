package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.dto.GoodTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/goodType")
public class GoodTypeController {
    private GoodTypeService goodTypeService;

    @Autowired
    public GoodTypeController(GoodTypeService goodTypeService) {
        this.goodTypeService = goodTypeService;
    }

    @PostMapping
    public ResponseEntity<GoodTypeDto> create(@RequestBody GoodTypeDto goodTypeDto) {
        return new ResponseEntity<>(goodTypeService.create(goodTypeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodTypeDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GoodTypeDto> update(@RequestBody GoodTypeDto goodTypeDto,
                                              @PathVariable Long id) {
        return new ResponseEntity<>(paymentService.update(goodTypeDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.delete(id), HttpStatus.OK);
    }
}
