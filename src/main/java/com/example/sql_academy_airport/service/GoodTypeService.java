package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.input.GoodTypeInputDto;
import com.example.sql_academy_airport.dto.output.GoodTypeOutputDto;

import java.util.Map;

public interface GoodTypeService {
    GoodTypeOutputDto create(GoodTypeInputDto goodTypeInputDto);

    GoodTypeOutputDto getById(Long id);

    GoodTypeOutputDto update(GoodTypeInputDto goodTypeInputDto, Long id);

    Map<String, Boolean> delete(Long id);
}
