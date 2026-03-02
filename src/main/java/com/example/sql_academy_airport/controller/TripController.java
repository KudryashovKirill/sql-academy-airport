package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.dto.TripDto;
import com.example.sql_academy_airport.model.Trip;
import com.example.sql_academy_airport.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("trip")
public class TripController {
    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public ResponseEntity<TripDto> create(@RequestBody TripDto tripDto) {
        return new ResponseEntity<>(tripService.create(tripDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TripDto> update(@RequestBody TripDto tripDto,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(tripService.update(tripDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.delete(id), HttpStatus.OK);
    }
}
