package ru.inbox.savinov_vu.model.local;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locals")
public class LocalStorage implements Serializable {

    @Id
    @JsonProperty("id")
    @SequenceGenerator(name = "LOCAL_SEQ", sequenceName = "LOCAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCAL_SEQ")
    private int id;

    @Column(name = "localname")
    @JsonProperty("localName")
    private String localName;

   public LocalStorage() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @Override
    public String toString() {
        return "LocalStorage{" +
                "id=" + id +
                ", localName='" + localName + '\'' +
                '}';
    }
}
