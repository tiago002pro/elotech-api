package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.exception.BusinesException;
import com.biblioteca.elotech_api.model.Book;
import com.biblioteca.elotech_api.model.Loan;
import com.biblioteca.elotech_api.model.User;
import com.biblioteca.elotech_api.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {

    @InjectMocks
    private LoanService service;

    @Mock
    LoanRepository repository;

    User user;
    Book book;
    Loan loan;

    @BeforeEach
    public void setUp() {
        user = new User(
                1L,
                "Tiago",
                "tiagobarbosa02@outlook.com",
                new Date(),
                "44999995555"
        );

        book = new Book(
                1L,
                "Livro 1",
                "Autor",
                "isbn",
                new Date(),
                "Aventura"
        );

        loan = new Loan(
                1L,
                user,
                book,
                new Date(),
                new Date(),
                "OPEN"
        );
    }

    @Test
    void testIfUserOfLoanIsNotNull() {
        assertNotNull(loan.getUser(), "Usuário é obrigatório!");
        verifyNoInteractions(repository);
    }

    @Test
    void testIfBookOfLoanIsNotNull() {
        assertNotNull(loan.getBook(), "Livro é obrigatório!");
        verifyNoInteractions(repository);
    }

    @Test
    void testIfStatusOfLoanIsNotNull() {
        assertNotNull(loan.getStatus(), "Situação é obrigatória!");
        verifyNoInteractions(repository);
    }
}
