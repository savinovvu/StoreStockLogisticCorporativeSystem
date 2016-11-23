package ru.inbox.savinov_vu.model.goods.status;


import com.fasterxml.jackson.annotation.JsonProperty;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.model.personal.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "currentstatus")
public class StatusProduct {

    @Id
    @Column(name = "statusId")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int status_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusName")
    @JsonProperty("statusName")
    private EnumStatusProduct statusName;


    @Column(name = "statusDate")
    @JsonProperty("statusDate")
    private LocalDate date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonProperty("product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    @JsonProperty("user")
    private User user;

    public StatusProduct() {
    }

    ;

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public EnumStatusProduct getStatusName() {
        return statusName;
    }

    public void setStatusName(EnumStatusProduct statusName) {
        this.statusName = statusName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "StatusProduct{" +
                "status_id=" + status_id +
                ", statusName=" + statusName +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
