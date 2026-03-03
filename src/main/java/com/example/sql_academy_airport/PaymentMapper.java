package com.example.sql_academy_airport;

import com.example.sql_academy_airport.dto.input.PaymentInputDto;
import com.example.sql_academy_airport.dto.output.PaymentOutputDto;
import com.example.sql_academy_airport.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FamilyMemberMapper.class, GoodMapper.class})
public interface PaymentMapper {
    PaymentOutputDto toDto(Payment payment);

    List<PaymentOutputDto> toDtoList(List<Payment> payments);

    Payment toEntity(PaymentInputDto paymentInputDto);

    void updateEntityFromDto(PaymentInputDto dto,
                             @MappingTarget Payment entity);
}
