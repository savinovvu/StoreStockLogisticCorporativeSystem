package ru.inbox.savinov_vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.inbox.savinov_vu.service.UserService;

public class UserController {
    @Autowired
    UserService service;
    public void start() {
        service.getAllOrders();
    }
}
