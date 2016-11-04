package ru.inbox.savinov_vu.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.inbox.savinov_vu.controller.OrderController;
import ru.inbox.savinov_vu.controller.UserController;

public class ConfigApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"context/context.xml"});
        ClassPathXmlApplicationContext dbContext = new ClassPathXmlApplicationContext(new String[]{"db/db.xml"});
        UserController userController = (UserController) context.getBean("userController");
        OrderController orderController= (OrderController) context.getBean("orderController");
        userController.start();
        orderController.start();
    }

}
