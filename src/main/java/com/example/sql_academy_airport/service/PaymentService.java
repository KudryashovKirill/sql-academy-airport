package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.input.PaymentInputDto;
import com.example.sql_academy_airport.dto.output.PaymentOutputDto;

import java.util.Map;

public interface PaymentService {
    PaymentOutputDto create(PaymentInputDto paymentInputDto);

    PaymentOutputDto getById(Long id);

    PaymentOutputDto update(PaymentInputDto paymentInputDto, Long id);

    Map<String, Boolean> delete(Long id);
}
