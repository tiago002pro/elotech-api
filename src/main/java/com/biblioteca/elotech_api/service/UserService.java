package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.model.User;
import com.biblioteca.elotech_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User load(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }
}
