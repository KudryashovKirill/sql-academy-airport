package com.example.sql_academy_airport.dto.output;

import com.example.sql_academy_airport.model.GoodType;
import com.example.sql_academy_airport.model.Payment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class GoodOutputDto {
    Long goodId;
    String goodName;
    GoodType type;
    List<PaymentOutputDto> payments;
}
