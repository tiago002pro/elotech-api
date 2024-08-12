package com.biblioteca.elotech_api.model;

import com.biblioteca.elotech_api.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "book")
@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "category")
    private String category;

    public Book(BookDTO dto) {
        this.title = dto.getTitle();
        this.author = dto.getAuthor();
        this.isbn = dto.getIsbn();
        this.publicationDate = dto.getPublicationDate();
        this.category = dto.getCategory();
    }

    public Book(Long id, String title, String author, String isbn, Date publicationDate, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
    }
}
