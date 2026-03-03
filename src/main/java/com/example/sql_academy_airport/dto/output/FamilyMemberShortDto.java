package com.example.sql_academy_airport.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMemberShortDto {
    private Long memberId;
    private String memberName;
}
