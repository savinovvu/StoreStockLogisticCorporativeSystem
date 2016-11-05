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

    @Column(name = "startDate")
    @JsonProperty("startDate")
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime startDateTime;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "order")
    @OrderBy("dateTime DESC")
    private List<Product> productList;

    public Order() {}

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
}
