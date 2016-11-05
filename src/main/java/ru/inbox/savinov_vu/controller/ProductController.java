package ru.inbox.savinov_vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.ProductService;

public class ProductController {

    @Qualifier("productService")
    @Autowired
    ProductService service;

    public void start() {
        service.getAll();
    }
}
