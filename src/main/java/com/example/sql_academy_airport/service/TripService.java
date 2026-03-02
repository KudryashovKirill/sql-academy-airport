package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.CompanyDto;
import com.example.sql_academy_airport.dto.TripDto;

import java.util.Map;

public interface TripService {
    TripDto create(TripDto tripDto);

    TripDto getById(Long id);

    TripDto update(TripDto tripDto, Long id);

    Map<String, Boolean> delete(Long id);
}
