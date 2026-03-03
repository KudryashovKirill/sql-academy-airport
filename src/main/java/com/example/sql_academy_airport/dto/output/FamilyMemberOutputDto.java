package com.example.sql_academy_airport.dto.output;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class FamilyMemberOutputDto {
    Long memberId;
    String status;
    String memberName;
    LocalDate birthday;
    List<PaymentOutputDto> payments;
}
