package com.biblioteca.elotech_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "loan")
@Entity
@Data
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "loan_date")
    private Date loanDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "status")
    private String status;

    public Loan(Long id, User user, Book book, Date loanDate, Date returnDate, String status) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.status = status;
    }
}
