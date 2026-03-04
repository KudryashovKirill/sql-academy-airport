package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.PassengerDto;
import com.example.sql_academy_airport.model.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerDto toDto(Passenger passenger);

    Passenger toEntity(PassengerDto passengerDto);

    void updateEntityFromDto(PassengerDto dto,
                             @MappingTarget Passenger passenger);
}
