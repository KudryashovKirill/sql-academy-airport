package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.Payment;

import java.util.List;
import java.util.Map;

public interface PaymentRepository {
    Payment create(Payment payment);

    Payment getById(Long id);

    Payment update(Payment payment, Long id);

    Map<String, Boolean> delete(Long id);

    List<Payment> findByFamilyMemberId(Long memberId);
}
