package com.example.sql_academy_airport.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family_members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberId;
    @Column(name = "status", nullable = false, length = 100)
    String status;
    @Column(name = "member_name", nullable = false)
    String memberName;
    @Column(name = "birthday", nullable = false)
    LocalDate birthday;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyMember")
    List<Payment> payments = new ArrayList<>();

    public FamilyMember(Long memberId, String status, String memberName, LocalDate birthday) {
        this.memberId = memberId;
        this.status = status;
        this.memberName = memberName;
        this.birthday = birthday;
    }
}
