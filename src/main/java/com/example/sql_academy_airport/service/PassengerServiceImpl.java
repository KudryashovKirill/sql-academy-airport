package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.PassengerDto;
import com.example.sql_academy_airport.util.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;
    private PassengerMapper mapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.mapper = passengerMapper;
    }

    @Override
    public PassengerDto create(PassengerDto passengerDto) {
        Passenger passenger = mapper.toEntity(passengerDto);
        return mapper.toDto(passengerRepository.create(passenger));
    }

    @Override
    public PassengerDto getById(Long id) {
        return mapper.toDto(passengerRepository.getById(id));
    }

    @Override
    public PassengerDto update(PassengerDto passengerDto, Long id) {
        Passenger passenger = mapper.toEntity(passengerDto);
        return mapper.toDto(passengerRepository.update(passenger, id));
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return passengerRepository.delete(id);
    }
}
