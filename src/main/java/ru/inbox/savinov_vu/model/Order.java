package ru.inbox.savinov_vu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.inbox.savinov_vu.util.JsonDateSerializer;

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
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime startDateTime;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "order")
 /*   @OrderBy("dateTime DESC")*/
    private List<Product> products;

    public Order() {}

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
                ", startDateTime=" + startDateTime +
                ", order_id=" + order_id +
                " products=" + products + " "+
                '}';
    }
}
