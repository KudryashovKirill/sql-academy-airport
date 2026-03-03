package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.input.GoodInputDto;
import com.example.sql_academy_airport.dto.output.GoodTypeOutputDto;
import com.example.sql_academy_airport.model.Good;
import com.example.sql_academy_airport.model.GoodType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GoodMapper.class})
public interface GoodTypeMapper {
    GoodTypeOutputDto toDto(GoodType goodType);

    Good toEntity(GoodInputDto goodInputDto);
}
