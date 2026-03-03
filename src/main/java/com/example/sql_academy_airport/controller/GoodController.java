package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.dto.output.GoodOutputDto;
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
    public ResponseEntity<GoodOutputDto> create(@RequestBody GoodOutputDto goodOutputDto) {
        return new ResponseEntity<>(goodService.create(goodOutputDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodOutputDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(goodService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GoodOutputDto> update(@RequestBody GoodOutputDto goodOutputDto,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(goodService.update(goodOutputDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(goodService.delete(id), HttpStatus.OK);
    }
}
