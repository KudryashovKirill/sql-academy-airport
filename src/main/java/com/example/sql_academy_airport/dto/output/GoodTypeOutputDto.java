package com.example.sql_academy_airport.dto.output;

import com.example.sql_academy_airport.model.Good;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class GoodTypeOutputDto {
    Long goodTypeId;
    String goodTypeName;
    List<GoodOutputDto> goods;
}
