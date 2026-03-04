package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.Trip;
import com.example.sql_academy_airport.util.exception.WrongIdForUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.NoSuchElementException;

@Repository
public class TripRepositoryImpl implements TripRepository {
    private JdbcTemplate template;
    private SimpleJdbcInsert insert;
    private final CompanyRepository companyRepository;

    @Autowired
    public TripRepositoryImpl(JdbcTemplate template, CompanyRepository companyRepository) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template)
                .withTableName("trips")
                .usingGeneratedKeyColumns("id");
        this.companyRepository = companyRepository;
    }

    @Override
    public Trip create(Trip trip) {
        Map<String, Object> params = Map.of("plane", trip.getPlane(),
                "company", trip.getCompany().getId(),
                "town_from", trip.getTownFrom(),
                "town_to", trip.getTownTo(),
                "time_out", trip.getTimeOut(),
                "time_in", trip.getTimeIn());
        Number id = insert.executeAndReturnKey(params);
        trip.setId(id.longValue());
        return trip;
    }

    @Override
    public Trip getById(Long id) {
        String sqlQuery = """
                SELECT *
                FROM trips
                WHERE id = ?
                """;
        try {
            return template.queryForObject(sqlQuery, (rs, rowNum) -> {
                        Trip t = rowMapper(rs);
                        t.setCompany(companyRepository.getById(rs.getLong("company")));
                        return t;
                    }, id
            );
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("trip not found with id");
        }
    }

    @Override
    public Trip update(Trip trip, Long id) {
        String sqlQuery = """
                UPDATE trips
                SET plane = ?, town_from = ?, town_to = ?, time_out = ?, time_in = ?
                WHERE id = ?
                """;
        int countOfUpdated = template.update(sqlQuery, trip.getPlane(), trip.getTownFrom(), trip.getTownTo(),
                trip.getTimeOut(), trip.getTimeIn(), id);
        if (countOfUpdated == 0) {
            throw new WrongIdForUpdateException("wrong id for update trip");
        }
        trip.setId(id);
        return trip;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        String sqlQuery = """
                DELETE FROM trips
                WHERE id = ?
                """;
        int countOfDeletedTrips = template.update(sqlQuery, id);
        return Map.of("deleted", countOfDeletedTrips > 0);
    }

    private Trip rowMapper(ResultSet rs) throws SQLException {
        return new Trip(rs.getLong("id"),
                rs.getString("plane"),
                rs.getString("town_from"),
                rs.getString("town_to"),
                rs.getTimestamp("time_out").toLocalDateTime(),
                rs.getTimestamp("time_in").toLocalDateTime()
        );
    }
}
