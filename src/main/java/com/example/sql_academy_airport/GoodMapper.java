package com.example.sql_academy_airport;

import com.example.sql_academy_airport.dto.input.GoodInputDto;
import com.example.sql_academy_airport.dto.output.GoodOutputDto;
import com.example.sql_academy_airport.model.Good;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PaymentMapper.class})
public interface GoodMapper {
    GoodOutputDto toDto(Good good);

    @Mapping(target = "type", ignore = true)
    Good toEntity(GoodInputDto goodInputDto);

    void updateEntityFromDto(GoodInputDto dto,
                             @MappingTarget Good entity);
}
