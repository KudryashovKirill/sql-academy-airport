package com.example.sql_academy_airport.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter

public class GoodTypeInputDto {
    @NotBlank(message = "goodTypeName can`t be empty")
    String goodTypeName;
}
