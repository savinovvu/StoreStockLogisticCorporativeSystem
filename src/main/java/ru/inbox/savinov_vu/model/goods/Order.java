package ru.inbox.savinov_vu.model.goods;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.inbox.savinov_vu.util.json.JsonDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    /*Сделать 12 цифр*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("order_id")
    private int order_id;

    @Column(name = "startDateTime")
    @JsonProperty("startDateTime")
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDateTime startDateTime;

    @Column(name = "active")
    @JsonProperty("active")
    private boolean active;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "order")
    @JsonProperty("products")
    private List<Product> products;






    public Order() {}

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", startDateTime=" + startDateTime +
                ", products=" + products +
                '}';
    }
}
