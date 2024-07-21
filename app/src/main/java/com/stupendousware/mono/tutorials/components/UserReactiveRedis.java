package com.stupendousware.mono.tutorials.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.stupendousware.mono.tutorials.models.User;

import reactor.core.publisher.Mono;

@Component
public class UserReactiveRedis {
    private ReactiveRedisOperations<String, User> userOperations;
    private ReactiveHashOperations<String, String, User> opsForHash;

    @Autowired
    public UserReactiveRedis(ReactiveRedisOperations<String, User> userOperations) {
        this.userOperations = userOperations;
        this.opsForHash = this.userOperations.opsForHash();
    }

    public Mono<Boolean> put(String hashValue, User user) {
        return this.opsForHash
                .put(hashValue, "user", user);
    }

    public Mono<User> get(String hashValue) {
        return this.opsForHash
                .get(hashValue, "user");
    }
}
