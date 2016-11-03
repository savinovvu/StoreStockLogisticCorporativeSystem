package ru.inbox.savinov_vu.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class User {

    private int id;

    private String name;


    @Enumerated(EnumType.STRING)
    private Role role;
}
