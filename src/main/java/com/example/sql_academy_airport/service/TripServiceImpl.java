package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.PaymentDto;
import com.example.sql_academy_airport.util.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TripServiceImpl implements TripService {
    private TripRepository tripRepository;
    private TripMapper mapper;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, TripMapper mapper) {
        this.tripRepository = tripRepository;
        this.mapper = mapper;
    }

    @Override
    public PaymentDto create(PaymentDto paymentDto) {
        Trip trip = mapper.toEntity(paymentDto);
        return mapper.toDto(tripRepository.create(trip));
    }

    @Override
    public PaymentDto getById(Long id) {
        return mapper.toDto(tripRepository.getById(id));
    }

    @Override
    public PaymentDto update(PaymentDto paymentDto, Long id) {
        Trip trip = mapper.toEntity(paymentDto);
        return mapper.toDto(tripRepository.upsate(trip, id));
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return tripRepository.delete(id);
    }
}
