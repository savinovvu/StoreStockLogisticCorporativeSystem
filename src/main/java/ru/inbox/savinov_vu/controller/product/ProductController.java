package ru.inbox.savinov_vu.controller.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.service.goods.ProductService;

import java.util.List;


@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Qualifier("productService")
    @Autowired
    ProductService service;


    @GetMapping(value = "/all")
    public List<Product> getAllOrders(Model model) throws JsonProcessingException {
        return service.getAllProducts();

    }


}
