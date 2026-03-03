package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.input.GoodInputDto;
import com.example.sql_academy_airport.dto.output.GoodOutputDto;
import com.example.sql_academy_airport.model.Good;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaymentMapper.class})
public interface GoodMapper {
    GoodOutputDto toDto(Good good);

    Good toEntity(GoodInputDto goodInputDto);

}
