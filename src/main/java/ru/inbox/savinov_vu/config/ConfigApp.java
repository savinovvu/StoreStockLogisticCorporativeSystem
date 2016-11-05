package ru.inbox.savinov_vu.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.inbox.savinov_vu.controller.OrderController;
import ru.inbox.savinov_vu.controller.ProductController;
import ru.inbox.savinov_vu.controller.UserController;

public class ConfigApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("db/db.xml","context/context.xml");
        UserController userController = (UserController) context.getBean("userController");
        OrderController orderController= (OrderController) context.getBean("orderController");
        ProductController productController= (ProductController) context.getBean("productController");
        /*userController.start();
        orderController.start();*/
        productController.start();

    }

}
