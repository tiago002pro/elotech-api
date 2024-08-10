package com.biblioteca.elotech_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "phone")
    private String phone;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Loan> loanList;
}
