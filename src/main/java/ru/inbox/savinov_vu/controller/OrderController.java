package ru.inbox.savinov_vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.OrderService;

public class OrderController {
    @Qualifier("orderService")
    @Autowired
    OrderService service;

    public void start() {
        service.getAllOrders();


    }
}
