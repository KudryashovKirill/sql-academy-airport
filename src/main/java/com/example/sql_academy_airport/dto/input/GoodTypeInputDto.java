package com.example.sql_academy_airport.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class GoodTypeInputDto {
    @NotBlank(message = "goodTypeName can`t be empty")
    String goodTypeName;
}
