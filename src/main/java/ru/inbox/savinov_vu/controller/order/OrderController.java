package ru.inbox.savinov_vu.controller.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.model.goods.ProductOrder;
import ru.inbox.savinov_vu.model.goods.status.EnumStatusProduct;
import ru.inbox.savinov_vu.model.goods.status.StatusProduct;
import ru.inbox.savinov_vu.service.goods.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
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

    /*        this.startDate = startDate;
        this.active = active;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.orderComment = orderComment;


    /*    this.vendorCode = vendorCode;
        this.product_name = product_name;
        this.order = order;
        this.countProducts = countProducts;
        this.prepayment = prepayment;
        this.status = status;
        this.actualStatus = actualStatus;*/

    /*  this.statusName = statusName;
        this.date = date;
        this.product = product;
        this.user = user;*/

    @GetMapping (value = "/test")
    public List<ProductOrder> test(Model model) throws JsonProcessingException {
        ProductOrder order = new ProductOrder(LocalDate.now(), true, "customerName", "287346837", "comment");

        Product product = new Product(1232,"productname1",order,2,10000);


        List<StatusProduct> statusProducts = new ArrayList<>();
        statusProducts.add(new StatusProduct(EnumStatusProduct.Дозвон, LocalDate.now(),product));
        statusProducts.add(new StatusProduct(EnumStatusProduct.Комментарий, LocalDate.now(),product));
        statusProducts.add(new StatusProduct(EnumStatusProduct.Не_обработан, LocalDate.now(),product));

                product.setStatus(statusProducts);
        List<Product> products = new ArrayList<>();
        products.add(product);

        order.setProducts(products);
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
