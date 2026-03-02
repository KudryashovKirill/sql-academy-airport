package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.dto.GoodDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/good")
public class GoodController {
    private GoodService goodService;

    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

    @PostMapping
    public ResponseEntity<GoodDto> create(@RequestBody GoodDto goodDto) {
        return new ResponseEntity<>(goodService.create(goodDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(goodService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GoodDto> update(@RequestBody GoodDto goodDto,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(goodService.update(goodDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(goodService.delete(id), HttpStatus.OK);
    }
}
