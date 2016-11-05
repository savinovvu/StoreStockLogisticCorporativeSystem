package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.repository.ProductRepository;


@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository repository;
    @Override
    public String getAll() {
        repository.findAll().forEach(System.out::println);
        return null;
    }
}
