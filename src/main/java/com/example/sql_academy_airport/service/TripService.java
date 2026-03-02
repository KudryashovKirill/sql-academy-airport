package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.CompanyDto;
import com.example.sql_academy_airport.dto.PaymentDto;

import java.util.Map;

public interface TripService {
    PaymentDto create(PaymentDto paymentDto);

    PaymentDto getById(Long id);

    PaymentDto update(PaymentDto paymentDto, Long id);

    Map<String, Boolean> delete(Long id);
}
