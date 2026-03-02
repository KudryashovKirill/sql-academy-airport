package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.Good;

import java.util.Map;

public interface GoodRepository {
    Good create(Good good);

    Good getById(Long id);

    Good update(Good passenger, Long id);

    Map<String, Boolean> delete(Long id);
}
