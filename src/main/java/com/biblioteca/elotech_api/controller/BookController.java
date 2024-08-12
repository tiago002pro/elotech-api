package com.biblioteca.elotech_api.controller;

import com.biblioteca.elotech_api.dto.BookDTO;
import com.biblioteca.elotech_api.model.Book;
import com.biblioteca.elotech_api.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/books-available")
    public ResponseEntity<List<Book>> getAllBooksAvailable() {
        return ResponseEntity.ok((service).getAllBooksAvailable());
    }

    @GetMapping("/search-googke-books")
    public ResponseEntity searchGoogleBooks(@RequestParam String title) {
        return ResponseEntity.ok((service).searchGoogleBooks(title));
    }

    @PostMapping("/add-book-to-library")
    public ResponseEntity addBookToLibrary(@RequestParam String id) {
        return ResponseEntity.ok((service).addBookToLibrary(id));
    }

    @PostMapping("/add-book-list-to-library")
    public ResponseEntity addBookListToLibrary(@RequestBody List<BookDTO> dtoList) {
        return ResponseEntity.ok((service).addBookListToLibrary(dtoList));
    }

    @GetMapping("/recommendation-books")
    public ResponseEntity getRecommendationBooks(@RequestParam Long userId) {
        return ResponseEntity.ok((service).getRecommendationBooks(userId));
    }
}
