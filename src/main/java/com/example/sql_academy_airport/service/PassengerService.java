package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.PassengerDto;

import java.util.Map;

public interface PassengerService {
    PassengerDto create(PassengerDto passengerDto);

    PassengerDto getById(Long id);

    PassengerDto update(PassengerDto passengerDto, Long id);

    Map<String, Boolean> delete(Long id);

}
