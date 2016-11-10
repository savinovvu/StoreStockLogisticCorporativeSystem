package ru.inbox.savinov_vu.model.local;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "locals")
public class Local {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int localId;

    @Column(name = "localName")
    @JsonProperty("localName")
    private int localName;

    Local() {}

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getLocalName() {
        return localName;
    }

    public void setLocalName(int localName) {
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
