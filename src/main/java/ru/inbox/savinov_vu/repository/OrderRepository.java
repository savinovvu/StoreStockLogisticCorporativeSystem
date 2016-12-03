package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.goods.ProductOrder;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, Integer> {

   // @Query("select u from  u where u.active=true")
   // public List<Order> getAllActiveOrder();
}
