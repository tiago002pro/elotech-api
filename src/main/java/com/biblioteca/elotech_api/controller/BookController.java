package com.biblioteca.elotech_api.controller;

import com.biblioteca.elotech_api.model.Book;
import com.biblioteca.elotech_api.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/elotech-api/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok((service).save(book));
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return ResponseEntity.ok((service).save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            (service).delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> load(@PathVariable Long id) {
        return ResponseEntity.ok((service).load(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok((service).findAll());
    }

    @GetMapping("/search-books")
    public ResponseEntity searchBooks(@RequestParam String title) {
        return ResponseEntity.ok((service).searchBooks(title));
    }
}
