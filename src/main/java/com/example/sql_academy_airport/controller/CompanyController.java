package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.model.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.create(company), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Company> update(@RequestBody Company company,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(companyService.update(company, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.delete(id), HttpStatus.OK);
    }
}
