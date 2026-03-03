package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "good_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoodType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_type_id")
    Long GoodTypeId;
    @Column(name = "good_type_name", nullable = false, length = 100)
    String goodTypeName;
    @OneToMany(mappedBy = "type")
    List<Good> goods = new ArrayList<>();

    public GoodType(Long goodTypeId, String goodTypeName) {
        this.GoodTypeId = goodTypeId;
        this.goodTypeName = goodTypeName;
    }
}
