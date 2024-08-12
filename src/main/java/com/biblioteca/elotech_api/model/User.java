package com.biblioteca.elotech_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "phone")
    private String phone;

    public User(Long id, String name, String email, Date registrationDate, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.phone = phone;
    }
}
