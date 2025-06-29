package com.example;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceExceptionTest {

    @Test
    public void testUserNotFoundException() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(Optional.empty());

        UserService userService = new UserService(mockRepo);

        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(1L);
        });
    }
}
