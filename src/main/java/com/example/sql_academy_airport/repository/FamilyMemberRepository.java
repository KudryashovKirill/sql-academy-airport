package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.FamilyMember;

import java.util.Map;

public interface FamilyMemberRepository {
    FamilyMember create(FamilyMember familyMember);

    FamilyMember getById(Long id);

    FamilyMember update(FamilyMember familyMember, Long id);

    Map<String, Boolean> delete(Long id);
}
