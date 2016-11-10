package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.goods.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
