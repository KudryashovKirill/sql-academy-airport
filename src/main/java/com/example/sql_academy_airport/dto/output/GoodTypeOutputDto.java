package com.example.sql_academy_airport.dto.output;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class GoodTypeOutputDto {
    Long goodTypeId;
    String goodTypeName;
}
