package com.biblioteca.elotech_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "loan")
@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "loan_date")
    private Date loanDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "status")
    private String status;
}
