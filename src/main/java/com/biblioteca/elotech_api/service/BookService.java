package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.dto.BookDTO;
import com.biblioteca.elotech_api.exception.BusinesException;
import com.biblioteca.elotech_api.integration.GoogleBooksClient;
import com.biblioteca.elotech_api.model.Book;
import com.biblioteca.elotech_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.springframework.util.Assert.notNull;

@Service
public class BookService {
    private final BookRepository repository;
    private final GoogleBooksClient googleBooksClient;

    public BookService(BookRepository repository, GoogleBooksClient googleBooksClient) {
        this.repository = repository;
        this.googleBooksClient = googleBooksClient;
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Book load(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return this.repository.findAll();
    }

    public List<BookDTO> searchGoogleBooks(String query) {
        try {
            notNull(query, "Parâmetro é obrigatório!");
            List<Map<String, Object>> result = this.googleBooksClient.searchBook(query);

            if (Objects.nonNull(result) && !result.isEmpty()) {
                return result.stream().map(BookDTO::new).collect(Collectors.toList());
            }

            return new ArrayList<>();
        } catch (Exception e) {
            throw new BusinesException(format("Erro ao buscar os livros no Google Books. Parâmetro = %s", query), e);
        }
    }

    public List<Book> addBookToLibrary(String id) {
        List<BookDTO> bookList = this.searchGoogleBooks(id);

        if (Objects.nonNull(bookList) && !bookList.isEmpty()) {
            return this.addBookListToLibrary(bookList);
        }

        return null;
    }

    public List<Book> addBookListToLibrary(List<BookDTO> bookDTO) {
        List<Book> bookList = bookDTO.stream().map(Book::new).collect(Collectors.toList());
        return repository.saveAll(bookList);
    }

    public List<Book> getRecommendationBooks(Long userId) {
        return this.repository.getRecommendationBooks(userId);
    }
}
