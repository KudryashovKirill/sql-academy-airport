package com.example.sql_academy_airport.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class FamilyMemberInputDto {
    @NotBlank(message = "name must be not null")
    String memberName;
    @NotBlank(message = "status must be not null")
    String status;
    @PastOrPresent(message = "birthday can`t be in future")
    LocalDate birthday;
}
