package com.example.sql_academy_airport.dto.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter

public class GoodInputDto {
    @NotNull(message = "name must be not null")
    @Length(max = 100, message = "name can`t be more than 100 symbols")
    String goodName;
    @Min(value = 1, message = "type id can`t be 0 or less")
    Long goodType;
}
