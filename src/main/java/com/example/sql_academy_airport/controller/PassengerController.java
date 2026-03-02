package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.model.Passenger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<Passenger> create(@RequestBody Passenger passenger) {
        return new ResponseEntity<>(passengerService.create(passenger), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getById(@PathVariable Long id) {
        return new ResponseEntity<>(passengerService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Passenger> update(@RequestBody Passenger passenger,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(passengerService.update(passenger, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(passengerService.delete(id), HttpStatus.OK);
    }
}
