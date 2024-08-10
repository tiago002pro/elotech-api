package com.biblioteca.elotech_api.controller;

import com.biblioteca.elotech_api.model.Loan;
import com.biblioteca.elotech_api.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elotech-api/loan")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody Loan loan) {
        return ResponseEntity.ok((service).save(loan));
    }

    @PutMapping
    public ResponseEntity<Loan> update(@RequestBody Loan loan) {
        return ResponseEntity.ok((service).save(loan));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> load(@PathVariable Long id) {
        return ResponseEntity.ok((service).load(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getAll() {
        return ResponseEntity.ok((service).findAll());
    }
}
