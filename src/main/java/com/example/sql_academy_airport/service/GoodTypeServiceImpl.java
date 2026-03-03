package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.input.GoodTypeInputDto;
import com.example.sql_academy_airport.dto.output.GoodTypeOutputDto;
import com.example.sql_academy_airport.model.GoodType;
import com.example.sql_academy_airport.repository.GoodTypeRepository;
import com.example.sql_academy_airport.GoodTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class GoodTypeServiceImpl implements GoodTypeService {
    private final GoodTypeRepository goodTypeRepository;
    private final GoodTypeMapper mapper;

    @Autowired
    public GoodTypeServiceImpl(GoodTypeRepository goodTypeRepository, GoodTypeMapper mapper) {
        this.goodTypeRepository = goodTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public GoodTypeOutputDto create(GoodTypeInputDto goodTypeInputDto) {
        GoodType type = mapper.toEntity(goodTypeInputDto);
        return mapper.toDto(goodTypeRepository.create(type));
    }

    @Override
    public GoodTypeOutputDto getById(Long id) {
        return mapper.toDto(goodTypeRepository.getById(id));
    }

    @Override
    public GoodTypeOutputDto update(GoodTypeInputDto goodTypeInputDto, Long id) {
        GoodType inTable = mapper.toEntity(goodTypeInputDto);
        mapper.updateEntityFromDto(goodTypeInputDto, inTable);
        return mapper.toDto(goodTypeRepository.update(inTable, id));
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return goodTypeRepository.delete(id);
    }
}
