package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.exception.BusinesException;
import com.biblioteca.elotech_api.integration.GoogleBooksClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    GoogleBooksClient googleBooksClient;

    String query;

    @BeforeEach
    public void setUp() {
        query = "percy";
    }

    @Test
    void searchGoogleBooksWithoutParam() {
        final BusinesException e = assertThrows(BusinesException.class, () -> {
            bookService.searchGoogleBooks(null);
        });

        assertThat(e, notNullValue());
        assertThat(e.getMessage(), is("Erro ao buscar os livros no Google Books. Parâmetro = null"));
        assertThat(e.getCause(), notNullValue());
        assertThat(e.getCause().getMessage(), is("Parâmetro é obrigatório!"));
        verifyNoInteractions(googleBooksClient);
    }

    @Test
    void throwExceptionWhenGoogleBookFails() {
        when(googleBooksClient.searchBook(query)).thenThrow(new RuntimeException("Falha ao buscar os livros no Google Books!"));

        final BusinesException e = assertThrows(BusinesException.class, () -> {
            bookService.searchGoogleBooks(query);
        });

        assertThat(e.getMessage(), is(format("Erro ao buscar os livros no Google Books. Parâmetro = %s", query)));
        assertThat(e.getCause().getClass(), is(RuntimeException.class));
        assertThat(e.getCause().getMessage(), is("Falha ao buscar os livros no Google Books!"));
        verifyNoMoreInteractions(googleBooksClient);
    }
}
