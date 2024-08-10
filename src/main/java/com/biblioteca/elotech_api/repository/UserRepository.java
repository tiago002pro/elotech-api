package com.biblioteca.elotech_api.repository;

import com.biblioteca.elotech_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
