package ru.inbox.savinov_vu.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.repository.ProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository repository;
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
