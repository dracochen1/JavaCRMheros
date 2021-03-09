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
    private String Object;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String Type;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String RelatedPersons;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String Mission;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private Integer Cost;

    @Column(nullable = true)
    @JsonView(DetailView.class)
    private String Photo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getRelatedPersons() {
        return RelatedPersons;
    }

    public void setRelatedPersons(String relatedPersons) {
        RelatedPersons = relatedPersons;
    }

    public String getMission() {
        return Mission;
    }

    public void setMission(String mission) {
        Mission = mission;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
