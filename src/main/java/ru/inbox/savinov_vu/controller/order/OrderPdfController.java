package ru.inbox.savinov_vu.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.inbox.savinov_vu.model.goods.ProductOrder;
import ru.inbox.savinov_vu.service.goods.OrderService;

@Controller
public class OrderPdfController {


    @Qualifier("orderServiceImpl")
    @Autowired
    OrderService orderService;

/*
    Еo get pdf page need send request to URL: orders/page/{id}.pdf
*   for example: http://localhost:8080/orders/page/4.pdf
* */

    @GetMapping(value = "/orders/page/{id}")
    public void editOrder(Model model, @PathVariable("id") int id) {
        ProductOrder order = orderService.getOrderById(id);
        model.addAttribute("order", order);
    }

}
