package com.example.sql_academy_airport.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {
    @NotNull(message = "name must be not null")
    @Length(max = 100, message = "name can`t be more than 100 symbols")
    String name;
}
