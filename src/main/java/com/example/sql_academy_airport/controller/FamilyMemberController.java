package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.model.FamilyMember;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/familyMember")
public class FamilyMemberController {
    private FamilyMemberService familyMemberService;

    public FamilyMemberController(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    @PostMapping
    public ResponseEntity<FamilyMember> create(@RequestBody FamilyMember familyMember) {
        return new ResponseEntity<>(familyMemberService.create(familyMember), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyMember> getById(@PathVariable Long id) {
        return new ResponseEntity<>(familyMemberService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FamilyMember> update(@RequestBody FamilyMember familyMember,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(familyMemberService.update(familyMember, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(familyMemberService.delete(id), HttpStatus.OK);
    }
}
