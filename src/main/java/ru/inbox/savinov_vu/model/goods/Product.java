package ru.inbox.savinov_vu.model.goods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.inbox.savinov_vu.model.goods.status.StatusProduct;
import ru.inbox.savinov_vu.util.json.JsonDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("product_id")
    private int product_id;

    @Column(name = "product_name")
    @JsonProperty("product_name")
    private String product_name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "startDateTime")
    @JsonProperty("startDateTime")
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private LocalDateTime startDateTime;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "product")
    @JsonProperty("status")
    private List<StatusProduct> status;



    @Transient
    @JsonProperty("actualStatus")
    private List<StatusProduct> actualStatus = new ArrayList<>();



    public Product() {

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public List<StatusProduct> getStatus() {
        return status;
    }

    public void setStatus(List<StatusProduct> status) {
        this.status = status;
    }


    public List<StatusProduct> getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(List<StatusProduct> actualStatus) {
        this.actualStatus = actualStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", startDateTime=" + startDateTime +
                ", status=" + status +
                '}';
    }
}
