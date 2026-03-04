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
@Table(name = "companies")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false, unique = true, length = 100)
    String name;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    List<Trip> trip = new ArrayList<>();

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

