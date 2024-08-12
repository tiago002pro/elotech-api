package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.exception.BusinesException;
import com.biblioteca.elotech_api.model.Loan;
import com.biblioteca.elotech_api.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.springframework.util.Assert.notNull;

@Service
public class LoanService {
    private final LoanRepository repository;
    private final BookService bookService;

    public LoanService(LoanRepository repository,
                       BookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }

    public Loan save(Loan loan) {
        notNull(loan.getUser(), "Usuário é obrigatório!");
        notNull(loan.getBook(), "Livro é obrigatório!");
        notNull(loan.getStatus(), "Situação é obrigatória!");

        Boolean avalible = this.bookService.checkIfTheBookIsAvailable(loan.getBook().getId());
        if (avalible) {
            return repository.save(loan);
        } else {
            throw new BusinesException("Livro indisponível para o empréstimo!");
        }
    }

    public Loan load(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Loan> findAll() {
        return this.repository.findAll();
    }
}
