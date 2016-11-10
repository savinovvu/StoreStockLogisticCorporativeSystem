package ru.inbox.savinov_vu.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.goods.OrderService;


public class OrderController {
    @Qualifier("orderService")
    @Autowired
    OrderService service;

    public void start() {




    }

}
