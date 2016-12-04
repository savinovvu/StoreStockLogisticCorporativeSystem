package ru.inbox.savinov_vu.model.goods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.inbox.savinov_vu.model.goods.status.StatusProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @JsonProperty("product_id")
    @SequenceGenerator(name = "PRODUCT_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    private int product_id;

    @Column(name = "vendorCode")
    @JsonProperty("vendorCode")
    private int vendorCode;

    @Column(name = "product_name")
    @JsonProperty("product_name")
    private String product_name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private ProductOrder order;

    @Column(name = "countProducts")
    @JsonProperty("countProducts")
    private int countProducts;

    @Column(name = "prepayment")
    @JsonProperty("prepayment")
    private int prepayment;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "product")
    @JsonProperty("status")
    private List<StatusProduct> status;



    @Transient
    @JsonProperty("actualStatus")
    private List<StatusProduct> actualStatus = new ArrayList<>();



    public Product() {

    }

    public int getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(int countProducts) {
        this.countProducts = countProducts;
    }

    public int getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(int prepayment) {
        this.prepayment = prepayment;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
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

    public ProductOrder getOrder() {
        return order;
    }

    public void setOrder(ProductOrder order) {
        this.order = order;
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
                ", status=" + actualStatus +
                '}';
    }
}
