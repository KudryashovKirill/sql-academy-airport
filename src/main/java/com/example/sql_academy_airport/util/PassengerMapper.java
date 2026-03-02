package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.PassengerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerDto toDto(Passenger passenger);

    Passenger toEntity(PassengerDto passengerDto);

}
