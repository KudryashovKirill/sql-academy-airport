package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.input.PaymentInputDto;
import com.example.sql_academy_airport.dto.output.PaymentOutputDto;
import com.example.sql_academy_airport.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FamilyMemberMapper.class, GoodMapper.class})
public interface PaymentMapper {
    PaymentOutputDto toDto(Payment payment);

    Payment toEntity(PaymentInputDto paymentInputDto);
}
