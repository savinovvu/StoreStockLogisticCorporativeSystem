package ru.inbox.savinov_vu.service.goods.util;

import ru.inbox.savinov_vu.model.goods.Order;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.model.goods.status.StatusProduct;

import java.util.ArrayList;
import java.util.List;

public class PrepareProductForSend {




    public List<Order> prepareOrders(List<Order> orders) {
        orders.forEach(order -> prepare(order));
        return orders;
    }


    public Order prepare(Order order){
        prepare(order.getProducts());
        return order;
    }


    public List<Product> prepare(List<Product> products){
        products.forEach(product -> prepare(product)
        );

        return null;
    }

    public Product prepare(Product product) {
        List<StatusProduct> group1 = new ArrayList<>();
        List<StatusProduct> group2 = new ArrayList<>();
        List<StatusProduct> group3 = new ArrayList<>();
        List<StatusProduct> group4 = new ArrayList<>();
        List<StatusProduct> group5 = new ArrayList<>();
        product.getStatus().forEach(statusProduct -> {
            switch (statusProduct.getStatusName()) {
                case Обработан:
                case Не_обработан:
                case Отменен:
                    group1.add(statusProduct);
                    break;
                case Заказан:
                case Не_заказан:
                    group2.add(statusProduct);
                    break;
                case Выявлен_дефект:
                case Проверен_и_отложен:
                case Отсутствует:
                    group3.add(statusProduct);
                    break;
                case Дозвон:
                case Перезвонить:
                case Не_Звонили:
                    group4.add(statusProduct);
                    break;
                case Выдан:
                case Не_выдан:
                    group5.add(statusProduct);
                    break;
            }
        });

        List<StatusProduct> actualStatus = product.getActualStatus();
        if(group1.size() > 0) actualStatus.add(group1.get(group1.size()-1));
        if(group2.size() > 0) actualStatus.add(group2.get(group2.size()-1));
        if(group3.size() > 0) actualStatus.add(group3.get(group3.size()-1));
        if(group4.size() > 0) actualStatus.add(group4.get(group4.size()-1));
        if(group5.size() > 0) actualStatus.add(group5.get(group5.size()-1));

        return product;
    }


}
