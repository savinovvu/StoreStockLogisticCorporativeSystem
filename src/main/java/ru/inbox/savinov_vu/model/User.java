package ru.inbox.savinov_vu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;


    @Column(name = "userName")
    @JsonProperty("userName")
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    @JsonProperty("roles")
    private Role roles;

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

    public Role getRole() {
        return roles;
    }

    public void setRole(Role role) {
        this.roles = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
