package com.example.sql_academy_airport;

import com.example.sql_academy_airport.dto.input.GoodTypeInputDto;
import com.example.sql_academy_airport.dto.output.GoodTypeOutputDto;
import com.example.sql_academy_airport.model.GoodType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {GoodMapper.class})
public interface GoodTypeMapper {
    GoodTypeOutputDto toDto(GoodType goodType);

    GoodType toEntity(GoodTypeInputDto goodInputDto);

    void updateEntityFromDto(GoodTypeInputDto goodTypeInputDto,
                             @MappingTarget GoodType goodType);
}
