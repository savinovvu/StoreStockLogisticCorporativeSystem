package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.goods.ProductOrder;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, Integer> {

    @Query("select p from ProductOrder p where p.active=true")
     List<ProductOrder> getAllActiveOrder();

    @Query("select count(p) from ProductOrder p WHERE p.active=true")
    long countActiveOrder();

    @Query("select count(p) from ProductOrder p")
    long countAllOrder();

    @Query("select MAX(p.order_id) from ProductOrder p")
     int getMaxOrderId();

    @Query("select p FROM ProductOrder p WHERE p.id =:id ")
     ProductOrder findById(@Param("id")int id);






}
