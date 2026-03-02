package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.model.Trip;
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
    public ResponseEntity<Trip> create(@RequestBody Trip trip) {
        return new ResponseEntity<>(tripService.create(trip), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Trip> update(@RequestBody Trip Trip,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(tripService.update(Trip, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.delete(id), HttpStatus.OK);
    }
}
