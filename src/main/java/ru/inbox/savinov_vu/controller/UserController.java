package ru.inbox.savinov_vu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.model.User;
import ru.inbox.savinov_vu.service.UserService;

import static spark.Spark.*;


public class UserController {

    @Qualifier("userService")
    @Autowired
    UserService service;

    @Autowired
    ObjectMapper mapper;


    public void start() {
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        try {
            System.out.println(service.getAllActiveUsers());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");
        System.out.println("ACtiveusers");

        staticFileLocation("/public");

        get("/AllUsers", (req, res) -> {
            return service.getAllUsers();
        });

        get("/AllActiveUsers", (req, res) -> {
            return service.getAllActiveUsers();
        });

        put("/putUser", (req, res) -> {
            User user = mapper.readValue(req.body(), User.class);
            service.addUser(user);
            return null;
        });

        post("/changeActiveUser", (req, res) -> {
            User user = mapper.readValue(req.body(), User.class);
            service.addUser(user);
            return null;
        });

    }
}
