package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false, length = 100)
    String name;
    @OneToMany(mappedBy = "passenger")
    List<PassInTrip> trips = new ArrayList<>();

    public Passenger(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
