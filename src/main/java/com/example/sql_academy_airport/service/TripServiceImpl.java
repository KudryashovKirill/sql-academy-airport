package com.example.sql_academy_airport.service;

import com.example.sql_academy_airport.dto.TripDto;
import com.example.sql_academy_airport.model.Trip;
import com.example.sql_academy_airport.repository.CompanyRepository;
import com.example.sql_academy_airport.repository.TripRepository;
import com.example.sql_academy_airport.util.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TripServiceImpl implements TripService {
    private TripRepository tripRepository;
    private CompanyRepository companyRepository;
    private TripMapper mapper;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, CompanyRepository companyRepository, TripMapper mapper) {
        this.tripRepository = tripRepository;
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public TripDto create(TripDto tripDto) {
        Trip trip = mapper.toEntity(tripDto);
        trip.setCompany(companyRepository.getById(tripDto.getCompanyId()));
        return mapper.toDto(tripRepository.create(trip));
    }

    @Override
    public TripDto getById(Long id) {
        return mapper.toDto(tripRepository.getById(id));
    }

    @Override
    public TripDto update(TripDto tripDto, Long id) {
        Trip trip = mapper.toEntity(tripDto);
        mapper.updateEntityFromDto(tripDto, trip);
        return mapper.toDto(tripRepository.update(trip, id));
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        return tripRepository.delete(id);
    }
}
