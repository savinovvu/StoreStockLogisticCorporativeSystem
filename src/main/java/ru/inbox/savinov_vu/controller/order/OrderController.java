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

    @GetMapping (value = "/test")
    public ProductOrder test(Model model) throws JsonProcessingException {
   /*     ProductOrder order = new ProductOrder(LocalDate.now(), true, "customerName", "287346837", "comment");

        Product product = new Product(1232,"productname1",order,2,10000);


        List<StatusProduct> statusProducts = new ArrayList<>();
        statusProducts.add(new StatusProduct(EnumStatusProduct.Дозвон, LocalDate.now(),product));
        statusProducts.add(new StatusProduct(EnumStatusProduct.Комментарий, LocalDate.now(),product));
        statusProducts.add(new StatusProduct(EnumStatusProduct.Не_обработан, LocalDate.now(),product));

                product.setStatus(statusProducts);
        List<Product> products = new ArrayList<>();
        products.add(product);



        order.setProducts(products);
        orderService.putOrder(order);*/


        return  orderService.getOrderById(1);
    }




}
