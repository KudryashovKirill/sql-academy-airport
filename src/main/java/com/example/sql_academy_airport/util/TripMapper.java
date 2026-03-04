package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.TripDto;
import com.example.sql_academy_airport.model.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, PassengerMapper.class})
public interface TripMapper {
    TripDto toDto(Trip trip);

    Trip toEntity(TripDto tripDto);

    void updateEntityFromDto(TripDto dto,
                             @MappingTarget Trip trip);
}
