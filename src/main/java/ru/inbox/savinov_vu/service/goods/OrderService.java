package ru.inbox.savinov_vu.service.goods;

import ru.inbox.savinov_vu.model.goods.ProductOrder;

import java.util.List;

public interface OrderService {
    List<ProductOrder> getAllOrders();

    List<ProductOrder> getActiveOrders();

    ProductOrder getOrderById(int id);

    void putOrder(ProductOrder order);

    long countAllOrder();

    long countActiveOrder();

}