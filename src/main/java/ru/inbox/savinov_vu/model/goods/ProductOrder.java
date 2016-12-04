package ru.inbox.savinov_vu.model.goods;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.inbox.savinov_vu.util.json.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "orders")
public class ProductOrder {

    @Id
    @JsonProperty("order_id")
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    private int order_id;

    @Column(name = "startDate")
    @JsonProperty("startDate")
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate startDate;

    @Column(name = "active")
    @JsonProperty("active")
    private boolean active;

    @Column(name = "customerName")
    @JsonProperty("customerName")
    private String customerName;

    @Column(name = "customerPhone")
    @JsonProperty("customerPhone")
    private String customerPhone;

    @Column(name = "orderComment")
    @JsonProperty("orderComment")
    private String orderComment;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "order")
    @JsonProperty("products")
    private List<Product> products;










    public ProductOrder() {}


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public boolean getActive() {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "ProductOrder{" +
                "order_id=" + order_id +
                ", active=" + active +
                '}';
    }
}

