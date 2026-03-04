package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "plane", nullable = false, length = 100)
    String plane;
    @Column(name = "townFrom", nullable = false, length = 100)
    String townFrom;
    @Column(name = "townTo", nullable = false, length = 100)
    String townTo;
    @Column(name = "timeOut", nullable = false)
    LocalDateTime timeOut;
    @Column(name = "timeIn", nullable = false)
    LocalDateTime timeIn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company", nullable = false)
    Company company;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    List<PassInTrip> passengers = new ArrayList<>();

    public Trip(Long id, String plane, String townFrom, String townTo, LocalDateTime timeOut, LocalDateTime timeIn) {
        this.id = id;
        this.plane = plane;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }
}

