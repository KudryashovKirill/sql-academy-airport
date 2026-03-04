package com.example.sql_academy_airport.dto;

import com.example.sql_academy_airport.model.Company;
import com.example.sql_academy_airport.model.PassInTrip;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class TripDto {
    @NotNull(message = "plane must be not null")
    @Length(max = 100, message = "plane can`t be more than 100 symbols")
    String plane;
    @NotNull(message = "townFrom must be not null")
    @Length(max = 100, message = "townFrom can`t be more than 100 symbols")
    String townFrom;
    @NotNull(message = "townTo must be not null")
    @Length(max = 100, message = "townTo can`t be more than 100 symbols")
    String townTo;
    LocalDateTime timeOut;
    LocalDateTime timeIn;
    Long companyId;
//    List<PassInTrip> passengers;

    public TripDto(String plane, String townFrom, String townTo, LocalDateTime timeOut, LocalDateTime timeIn) {
        this.plane = plane;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }
}
