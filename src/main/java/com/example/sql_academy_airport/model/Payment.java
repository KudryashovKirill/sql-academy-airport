package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long paymentId;
    @Column(name = "amount", nullable = false)
    Integer amount;
    @Column(name = "unitPrice", nullable = false)
    Integer unitPrice;
    @Column(name = "date", nullable = false)
    LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_member", nullable = false)
    FamilyMember familyMember;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "good", nullable = false)
    Good good;
}
