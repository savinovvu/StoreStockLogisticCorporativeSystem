package ru.inbox.savinov_vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.ProductService;
import spark.Spark;

public class ProductController {

    @Qualifier("productService")
    @Autowired
    ProductService service;

    public void start() {
        service.getAll();

        Spark.get("/hello2", (req, res) -> "Hello World2");
    }
}
