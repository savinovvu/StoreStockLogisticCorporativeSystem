package ru.inbox.savinov_vu.model.local;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "locals")
public class Local {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int local_id;

    @Column(name = "userName")
    @JsonProperty("userName")
    private int local_Name;

    Local() {}
}
