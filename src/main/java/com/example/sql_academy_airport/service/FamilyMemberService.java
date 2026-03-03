package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.input.FamilyMemberInputDto;
import com.example.sql_academy_airport.dto.output.FamilyMemberOutputDto;

import java.util.Map;

public interface FamilyMemberService {
    FamilyMemberOutputDto create(FamilyMemberInputDto familyMember);

    FamilyMemberOutputDto getById(Long id);

    FamilyMemberOutputDto update(FamilyMemberInputDto familyMember, Long id);

    Map<String, Boolean> delete(Long id);
}
