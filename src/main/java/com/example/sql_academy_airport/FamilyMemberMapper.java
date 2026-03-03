package com.example.sql_academy_airport;

import com.example.sql_academy_airport.dto.input.FamilyMemberInputDto;
import com.example.sql_academy_airport.dto.output.FamilyMemberOutputDto;
import com.example.sql_academy_airport.model.FamilyMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {PaymentMapper.class})
public interface FamilyMemberMapper {
    FamilyMemberOutputDto toDto(FamilyMember familyMember);

    FamilyMember toEntity(FamilyMemberInputDto familyMemberInputDto);

    void updateEntityFromDto(FamilyMemberInputDto dto,
                             @MappingTarget FamilyMember entity);
}
