package ru.inbox.savinov_vu.service.goods;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.goods.Order;
import ru.inbox.savinov_vu.repository.OrderRepository;
import ru.inbox.savinov_vu.service.goods.util.PrepareProductForSend;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        PrepareProductForSend prepare = new PrepareProductForSend();

        return prepare.prepareOrders(orderRepository.findAll());
    }
}
