package com.biblioteca.elotech_api.repository;

import com.biblioteca.elotech_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
