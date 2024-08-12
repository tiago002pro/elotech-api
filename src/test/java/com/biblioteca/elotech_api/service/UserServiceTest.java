package com.biblioteca.elotech_api.service;

import com.biblioteca.elotech_api.model.User;
import com.biblioteca.elotech_api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneId;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    User user;

    @BeforeEach
    public void setUp() {
        user = new User(
                1L,
                "Tiago",
                "tiagobarbosa02@outlook.com",
                new Date(),
                "44999995555"
        );
    }

    @Test
    void testGetUser() {
        when(repository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> userList = service.findAll();

        assertEquals(Collections.singletonList(user), userList);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }
}
