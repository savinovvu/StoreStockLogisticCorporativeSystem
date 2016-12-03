package ru.inbox.savinov_vu.model.goods.status;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.model.personal.User;
import ru.inbox.savinov_vu.util.json.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "currentstatus")
public class StatusProduct implements Comparable<StatusProduct>  {

    @Id
    @Column(name = "statusId")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int status_id;



    @Enumerated(EnumType.STRING)
    @Column(name = "statusName")
    @JsonProperty("statusName")
    private EnumStatusProduct statusName;


    @Column(name = "statusGroup")
    @JsonProperty("statusGroup")
    private int statusGroup;

    @Column(name = "statusDate")
    @JsonProperty("statusDate")
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)

    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    @JsonProperty("user")
    private User user;



    public StatusProduct() {

    }


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

    public int getStatusGroup() {
        return statusGroup;
    }

    public void setStatusGroup(int statusGroup) {
        this.statusGroup = statusGroup;
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


    @Override
    public int compareTo(StatusProduct o) {
        if (date == null) return 1;
        if (o.getDate() == null) return -1;
        return getStatus_id()>o.getStatus_id()? 1 : -1;
    }
}
