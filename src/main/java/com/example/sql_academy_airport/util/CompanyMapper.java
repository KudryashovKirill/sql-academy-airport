package com.example.sql_academy_airport.util;

import com.example.sql_academy_airport.dto.CompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDto toDto(Company company);

    Company toEntity(CompanyDto companyDto);
}
