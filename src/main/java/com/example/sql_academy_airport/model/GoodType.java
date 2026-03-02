package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "family_members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long GoodTypeId;
    @Column(name = "good_type_name", nullable = false, length = 100)
    String goodTypeName;
}
