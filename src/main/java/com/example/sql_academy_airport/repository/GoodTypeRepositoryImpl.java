package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.GoodType;
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
public class GoodTypeRepositoryImpl implements GoodTypeRepository {
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;

    @Autowired
    public GoodTypeRepositoryImpl(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template)
                .withTableName("good_types")
                .usingGeneratedKeyColumns("good_type_id");
    }

    @Override
    public GoodType create(GoodType goodType) {
        Map<String, Object> params = Map.of(
                "good_type_name", goodType.getGoodTypeName()
        );
        Number id = insert.executeAndReturnKey(params);
        goodType.setGoodTypeId(id.longValue());
        return goodType;
    }

    @Override
    public GoodType getById(Long id) {
        String sqlQuery = """
                SELECT * 
                FROM good_types
                WHERE good_type_id = ?
                """;
        try {
            return template.queryForObject(sqlQuery, (rs, rowNum) ->
                    rowMapper(rs), id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("no type found");
        }
    }

    @Override
    public GoodType update(GoodType goodType, Long id) {
        String sqlQuery = """
                UPDATE good_types
                SET good_type_name = ?
                WHERE good_type_id = ?
                """;
        int countOfUpdated = template.update(sqlQuery, goodType.getGoodTypeName(),
                id);
        if (countOfUpdated == 0) {
            throw new WrongIdForUpdateException("can`t update type by id");
        }
        goodType.setGoodTypeId(id);
        return goodType;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        String sqlQuery = """
                DELETE FROM good_types
                WHERE good_type_id = ?
                """;
        int countOfDeleted = template.update(sqlQuery, id);
        return Map.of("deleted", countOfDeleted > 0);
    }

    private GoodType rowMapper(ResultSet rs) throws SQLException {
        return new GoodType(
                rs.getLong("good_type_id"),
                rs.getString("good_type_name")
        );
    }
}
