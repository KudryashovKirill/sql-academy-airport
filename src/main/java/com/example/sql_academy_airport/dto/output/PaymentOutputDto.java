package com.example.sql_academy_airport.dto.output;

import com.example.sql_academy_airport.model.Good;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class PaymentOutputDto {
    Long paymentId;
    Integer amount;
    Integer unitPrice;
    LocalDateTime date;
    FamilyMemberOutputDto familyMember;
    Good good;
}
