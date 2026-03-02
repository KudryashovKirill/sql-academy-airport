package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.Company;
import com.example.sql_academy_airport.model.Trip;

import java.util.Map;

public interface TripRepository {
    Trip create(Trip trip);

    Trip getById(Long id);

    Trip update(Trip trip, Long id);

    Map<String, Boolean> delete(Long id);
}
