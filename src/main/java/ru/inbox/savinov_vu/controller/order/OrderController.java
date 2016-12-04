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
    OrderService service;


    @GetMapping(value = "/all")
    public List<ProductOrder> getAllOrders(Model model) throws JsonProcessingException {
        System.out.println(service.getAllOrders());
        return service.getAllOrders();

    }



    @GetMapping
    public List<ProductOrder> getActiveOrders(Model model) throws JsonProcessingException {
        return service.getActiveOrders();

    }


    @PutMapping
    public List<ProductOrder> getActiveOrders(Model model, @RequestBody ProductOrder order) throws JsonProcessingException {
        service.putOrder(order);
        return service.getActiveOrders();

    }




/*

    @ResponseBody
    @PutMapping
    public List<User> putUser(Model model, @RequestBody User user) throws IOException {
        service.addUser(user);
        return service.getAllActiveUsers();

    }


    @ResponseBody
    @PostMapping
    public List<User> changeActiveUser(Model model, @RequestBody User user) throws IOException {
        service.addUser(user);
        return service.getAllUsers();
    }
    */


}
