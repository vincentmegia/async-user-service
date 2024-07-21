package com.stupendousware.mono.tutorials.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stupendousware.mono.tutorials.components.UserReactiveRedis;
import com.stupendousware.mono.tutorials.models.User;
import com.stupendousware.mono.tutorials.services.UserService;

import reactor.core.publisher.Mono;

@RestController
public class UserController {
    private UserService userService;
    private UserReactiveRedis userReactiveRedis;

    public UserController(UserService userService, UserReactiveRedis userReactiveRedis) {
        this.userService = userService;
        this.userReactiveRedis = userReactiveRedis;
    }

    @GetMapping("/user")
    public Mono<User> getUser(@RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "lastname") String lastname) {
        var key = firstname + "." + lastname;
        return this.userReactiveRedis
                .get(key + "-key");
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        var key = user.firstname() + "." + user.lastname();
        this.userReactiveRedis
                .put(key + "-key", user);
    }
}
