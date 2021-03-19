package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Litige")
public class Litige {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String object;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String type;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String relatedPersons;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String mission;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private Integer cost;

    @Column(nullable = true)
    @JsonView(DetailView.class)
    private String photo;

    @ManyToOne
    @JsonView(ListView.class)
    private Crise crise;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelatedPersons() {
        return relatedPersons;
    }

    public void setRelatedPersons(String relatedPersons) {
        this.relatedPersons = relatedPersons;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Crise getCrise() {
        return crise;
    }

    public void setCrise(Crise crise) {
        this.crise = crise;
    }
}
