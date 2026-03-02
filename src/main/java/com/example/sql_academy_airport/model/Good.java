package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family_members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberId;
    @Column(name = "good_name", nullable = false, length = 100)
    String goodName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type", nullable = false)
    List<GoodType> types = new ArrayList<>();

}
