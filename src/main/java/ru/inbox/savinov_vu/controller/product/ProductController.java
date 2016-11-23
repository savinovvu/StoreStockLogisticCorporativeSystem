package ru.inbox.savinov_vu.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.inbox.savinov_vu.service.goods.ProductService;

public class ProductController {

    @Qualifier("productService")
    @Autowired
    ProductService service;



}
