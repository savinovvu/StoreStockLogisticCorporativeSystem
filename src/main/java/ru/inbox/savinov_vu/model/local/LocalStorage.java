package ru.inbox.savinov_vu.model.local;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "locals")
public class LocalStorage {

    @Id
    @Column(name = "localId")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int localId;

    @Column(name = "localname")
    @JsonProperty("localName")
    private String localName;


    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
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
                "localId=" + localId +
                ", localName='" + localName + '\'' +
                '}';
    }
}
