package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.GoodType;

import java.util.Map;

public interface GoodTypeRepository {
    GoodType create(GoodType goodType);

    GoodType getById(Long id);

    GoodType update(GoodType goodType, Long id);

    Map<String, Boolean> delete(Long id);
}
