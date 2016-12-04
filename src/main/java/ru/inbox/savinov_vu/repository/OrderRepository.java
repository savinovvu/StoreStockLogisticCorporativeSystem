package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.goods.ProductOrder;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query("select p from ProductOrder p where p.active=true")
    public List<ProductOrder> getAllActiveOrder();
}
