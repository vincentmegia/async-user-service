package com.stupendousware.mono.tutorials.services;

import org.springframework.stereotype.Service;

import com.stupendousware.mono.tutorials.models.User;
import com.stupendousware.mono.tutorials.repositories.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> getUser() {
        return this.userRepository
                .getUser();
    }
}
