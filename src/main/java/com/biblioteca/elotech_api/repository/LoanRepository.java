package com.biblioteca.elotech_api.repository;

import com.biblioteca.elotech_api.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
