package com.stupendousware.mono.tutorials.repositories;

import org.springframework.stereotype.Repository;

import com.stupendousware.mono.tutorials.models.User;

import reactor.core.publisher.Mono;

@Repository
public class UserRepository {
    public Mono<User> getUser() {
        return Mono.just(new User(1, "john", "doe", "82338537"));
    }
}
