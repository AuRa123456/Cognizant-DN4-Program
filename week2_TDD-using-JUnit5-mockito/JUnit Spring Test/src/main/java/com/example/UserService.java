package com.example;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    @SuppressWarnings("FieldMayBeFinal")
    private UserRepository userRepository;

    // ✅ Constructor for unit testing (optional for Spring)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
