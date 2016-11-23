package ru.inbox.savinov_vu.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.service.goods.OrderService;

@Controller
public class OrderController {
    @Qualifier("orderServiceImpl")
    @Autowired
    OrderService service;



    @GetMapping(value = "/editOrder")
    public String editOrder(Model model) {

            System.out.println(service.getAllOrders());
            return "goods/orderManage";


    }

}
