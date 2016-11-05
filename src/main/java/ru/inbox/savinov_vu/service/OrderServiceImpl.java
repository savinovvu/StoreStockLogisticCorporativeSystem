package ru.inbox.savinov_vu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inbox.savinov_vu.repository.OrderRepository;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean getAllOrders() {
        System.out.println(orderRepository.findAll());
        return false;
    }
}
