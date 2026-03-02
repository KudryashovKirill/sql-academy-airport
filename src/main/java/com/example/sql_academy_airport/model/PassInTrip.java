package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Pass_in_trip")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PassInTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "trip", nullable = false)
    Trip trip;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger", nullable = false)
    Passenger passenger;
    @Column(name = "place", nullable = false, length = 100)
    String place;

    public PassInTrip(Long id, Trip trip, Passenger passenger, String place) {
        this.id = id;
        this.trip = trip;
        this.passenger = passenger;
        this.place = place;
    }
}

