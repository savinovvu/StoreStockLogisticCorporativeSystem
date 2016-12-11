package ru.inbox.savinov_vu.controller.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.goods.ProductOrder;
import ru.inbox.savinov_vu.service.goods.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Qualifier("orderServiceImpl")
    @Autowired
    OrderService orderService;


    @GetMapping(value = "/all")
    public List<ProductOrder> getAllOrders(Model model) throws JsonProcessingException {
        System.out.println(orderService.getAllOrders());
        return orderService.getAllOrders();

    }


    @GetMapping
    public List<ProductOrder> getActiveOrders(Model model) throws JsonProcessingException {
        return orderService.getActiveOrders();
    }


    @PutMapping
    public List<ProductOrder> putOrders(Model model, @RequestBody ProductOrder order) throws JsonProcessingException {
        orderService.putOrder(order);
        return orderService.getActiveOrders();
    }

/*
    http://localhost:8080/orders/test
*/



    @GetMapping (value = "/countAllOrder")
    public long сountAllOrder(Model model) throws JsonProcessingException {
        return  orderService.countAllOrder();
    }


    @GetMapping (value = "/countActiveOrder")
    public long сountActiveOrder(Model model) throws JsonProcessingException {
       // return  orderService.countActiveOrder();
        return  orderService.countActiveOrder();
    }




}
