package ru.inbox.savinov_vu.service.goods.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inbox.savinov_vu.model.goods.Order;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.model.goods.status.EnumStatusProduct;
import ru.inbox.savinov_vu.repository.OrderRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.inbox.savinov_vu.model.goods.status.EnumStatusProduct.Выдан;
import static ru.inbox.savinov_vu.model.goods.status.EnumStatusProduct.Отменен;

@Component
public class CheckActiveOrder {
    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getActiveOrders(List<Order> orders){
        List<Order> activeOrders = new ArrayList<>();
        orders.forEach(order -> {
            if (getActiveOrder(order) != null) {
                activeOrders.add(order);
            }
        });
        return activeOrders;
    }

    public Order getActiveOrder(Order order) {
        Set<EnumStatusProduct> terminatedStatuses = new HashSet<>();
        terminatedStatuses.add(Отменен);
        terminatedStatuses.add(Выдан);
        Set<Product> terminatedProduct = new HashSet<>();
        order.getProducts().forEach(product -> {
            product.getStatus().forEach(statusProduct -> {
                        if (terminatedStatuses.contains(statusProduct)) {
                            terminatedProduct.add(product);
                        }
                    }
            );
        });
        if (terminatedProduct.size() == order.getProducts().size()){
            order.setActive(false);
            orderRepository.saveAndFlush(order);
            return null;
        }
        return order;
    }


}
