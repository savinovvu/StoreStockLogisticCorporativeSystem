package ru.inbox.savinov_vu.controller;

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


        staticFileLocation("/public");

        get("/AllUsers", (req, res) -> {
            return service.getAllUsers();
        });

        put("/putUser", (req, res) -> {
            User user = mapper.readValue(req.body(), User.class);
            service.addUser(user);
            return null;
        });

        post("/changeActiveUser", (req, res) -> {
            System.out.println(req.body());
            System.out.println(req.body());
            System.out.println(req.body());
            System.out.println(req.body());
            User user = mapper.readValue(req.body(), User.class);
            System.out.println(user);
            System.out.println(user);
            System.out.println(user);
            System.out.println(user);
            System.out.println(user);

             service.addUser(user);
            return null;
        });

    }
}
