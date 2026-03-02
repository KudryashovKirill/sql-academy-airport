package com.example.sql_academy_airport.repository;

import com.example.sql_academy_airport.model.Company;
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
public class CompanyRepositoryImpl implements CompanyRepository {
    JdbcTemplate template;
    SimpleJdbcInsert insert;

    @Autowired
    public CompanyRepositoryImpl(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template)
                .withTableName("company")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Company create(Company company) {
        Map<String, Object> params = Map.of("name", company.getName());
        Number id = insert.executeAndReturnKey(params);
        company.setId(id.longValue());
        return company;
    }

    @Override
    public Company getById(Long id) {
        String sqlQuery = """
                SELECT *
                FROM company
                WHERE id = ?
                """;
        try {
            return template.queryForObject(sqlQuery,
                    (rs, rowNum) -> rowMapper(rs),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("Company not found with id");
        }
    }

    @Override
    public Company update(Company company, Long id) {
        String sqlQuery = """
                UPDATE company
                SET name = ?
                WHERE id = ?
                """;
        int updatedCompanies = template.update(sqlQuery, company.getName(), id);
        if (updatedCompanies == 0) {
            throw new WrongIdForUpdateException("wrong id for update company");
        }
        company.setId(id);
        return company;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        String sqlQuery = """
                DELETE FROM company
                WHERE id = ?
                """;
        int countOfDeletedCompanies = template.update(sqlQuery, id);
        return Map.of("deleted", countOfDeletedCompanies > 0);
    }

    private Company rowMapper(ResultSet rs) throws SQLException {
        return new Company(
                rs.getLong("id"),
                rs.getString("name"));
    }
}



