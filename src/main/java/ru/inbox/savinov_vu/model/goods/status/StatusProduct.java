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
    @JsonProperty("id")
    @Column(name = "statusId")
    @SequenceGenerator(name = "STATUS_SEQ", sequenceName = "STATUS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_SEQ")
    private int statusId;



    @Enumerated(EnumType.STRING)
    @Column(name = "statusName")
    @JsonProperty("statusName")
    private EnumStatusProduct statusName;


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



    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
                "status_id=" + statusId +
                ", statusName=" + statusName +
                ", date=" + date +

                '}';
    }


    @Override
    public int compareTo(StatusProduct o) {
        if (date == null) return 1;
        if (o.getDate() == null) return -1;
        return getStatusId()>o.getStatusId()? 1 : -1;
    }
}
