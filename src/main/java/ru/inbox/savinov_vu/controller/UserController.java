package ru.inbox.savinov_vu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.UserService;

import static spark.Spark.post;
import static spark.Spark.staticFileLocation;


public class UserController {

    @Qualifier("userService")
    @Autowired
    UserService service;

    @Autowired
    ObjectMapper mapper;


    public void start() {


        staticFileLocation("/public");

    post("/getAll", (req, res) ->{
        return service.getAllUsers();
    });

    }
}
