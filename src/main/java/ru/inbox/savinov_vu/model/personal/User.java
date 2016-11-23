package ru.inbox.savinov_vu.model.personal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.inbox.savinov_vu.model.goods.status.StatusProduct;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @JsonProperty("id")
    private int id;


    @Column(name = "userName")
    @JsonProperty("userName")
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    @JsonProperty("roles")
    private Role roles;

    @JsonProperty("active")
    @Column(name = "active")
    private boolean active;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "user")
    private List<StatusProduct> status;



    public  User() {}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                ", active=" + active +
                '}';
    }
}
