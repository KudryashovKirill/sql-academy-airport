package com.example.sql_academy_airport.controller;

import com.example.sql_academy_airport.dto.PaymentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> create(@RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentService.create(trip), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaymentDto> update(@RequestBody PaymentDto paymentDto,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(paymentService.update(paymentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.delete(id), HttpStatus.OK);
    }
}
