package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.dto.PassengerDto;
import com.example.sql_academy_airport.model.Passenger;
import com.example.sql_academy_airport.service.PassengerService;
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
    public ResponseEntity<PassengerDto> create(@RequestBody PassengerDto passengerDto) {
        return new ResponseEntity<>(passengerService.create(passengerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(passengerService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PassengerDto> update(@RequestBody PassengerDto passengerDto,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(passengerService.update(passengerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(passengerService.delete(id), HttpStatus.OK);
    }
}
