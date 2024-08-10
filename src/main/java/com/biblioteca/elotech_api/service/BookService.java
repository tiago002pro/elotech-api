package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.model.Book;
import com.biblioteca.elotech_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
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
}
