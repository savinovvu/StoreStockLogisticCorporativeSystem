package ru.inbox.savinov_vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.UserService;
import spark.Spark;


public class UserController {

    @Qualifier("userService")
    @Autowired
    UserService service;

    public void start() {
        service.getAllUsers();

        Spark.get("/hello3", (req, res) -> "Hello World3");

    }
}
