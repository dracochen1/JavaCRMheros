package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Incident model, to be reactive in the event of danger
 */

@Entity(name = "incidents")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String type;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String description;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String location;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String source;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private boolean alert;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private boolean status;

    @ManyToOne
    @JsonView(ListView.class)
    private Civil civils;

    @OneToMany(mappedBy = "incident")
    @JsonView(ListView.class)
    private Set<Mission> missions;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;

    }
}

