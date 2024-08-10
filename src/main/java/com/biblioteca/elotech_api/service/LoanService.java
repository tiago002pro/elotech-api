package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.model.Loan;
import com.biblioteca.elotech_api.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public Loan save(Loan loan) {
        return repository.save(loan);
    }

    public Loan load(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Loan> findAll() {
        return this.repository.findAll();
    }
}
