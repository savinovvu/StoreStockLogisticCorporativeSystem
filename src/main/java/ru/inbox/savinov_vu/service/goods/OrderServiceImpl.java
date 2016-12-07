package ru.inbox.savinov_vu.service.goods;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.goods.ProductOrder;
import ru.inbox.savinov_vu.repository.OrderRepository;
import ru.inbox.savinov_vu.service.goods.util.CheckActiveOrder;
import ru.inbox.savinov_vu.service.goods.util.PrepareProductForSend;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;


    private void beforeGet() {
        CheckActiveOrder activeOrder = new CheckActiveOrder();
        activeOrder.getNOtActiveOrders(orderRepository.findAll()).forEach(productOrder -> {
                orderRepository.saveAndFlush(productOrder);
        });
    }

    private List<ProductOrder> preparedProduct(List<ProductOrder> productOrders) {
        PrepareProductForSend prepare = new PrepareProductForSend();
        return prepare.prepareOrders(productOrders);

    }

    @Override
    public List<ProductOrder> getAllOrders() {
        beforeGet();
        return preparedProduct(orderRepository.findAll());

    }

    @Override
    public List<ProductOrder> getActiveOrders() {
        beforeGet();
        return preparedProduct(orderRepository.getAllActiveOrder());

    }

    @Override
    public synchronized void putOrder(ProductOrder order) {

        orderRepository.saveAndFlush(order);
       // get id to saved order and redirect to pdf or send back.
        }

    @Override
    public ProductOrder getOrderById(int id) {
        return orderRepository.findOne(id);
    }


}
