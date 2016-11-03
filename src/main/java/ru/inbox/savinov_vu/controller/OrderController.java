package ru.inbox.savinov_vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.inbox.savinov_vu.service.OrderService;

public class OrderController {
    @Autowired
    OrderService service;

    public void start() {
        service.getAllOrders();


    }
}
