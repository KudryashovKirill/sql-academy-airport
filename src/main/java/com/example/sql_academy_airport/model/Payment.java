package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    Long paymentId;
    @Column(name = "amount", nullable = false)
    Integer amount;
    @Column(name = "unit_price", nullable = false)
    Integer unitPrice;
    @Column(name = "date", nullable = false)
    LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_member", nullable = false)
    FamilyMember familyMember;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "good", nullable = false)
    Good good;

    public Payment(Long paymentId, Integer amount, Integer unitPrice, LocalDate date) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.date = date;
    }
}
