package ru.inbox.savinov_vu.model.local;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "localStorages")
public class LocalStorage {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int localId;

    @Column(name = "localName")
    @JsonProperty("localName")
    private String localName;



    public LocalStorage() {}

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
        return "Local{" +
                "localId=" + localId +
                ", localName=" + localName +
                '}';
    }
}
