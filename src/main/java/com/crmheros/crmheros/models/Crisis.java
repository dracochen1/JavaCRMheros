package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Model of the crisis, in order to manage the damage of the supers
 */

@Entity(name = "crises")
public class Crisis {
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

    @ManyToOne
    @JsonView(ListView.class)
    private Report report;

    @ManyToOne
    @JsonView(ListView.class)
    private Mission mission;

    @OneToMany(mappedBy = "crisis")
    @JsonView(ListView.class)
    private Set<Litigation> litigations;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Set<Litigation> getLitigations() {
        return litigations;
    }

    public void setLitigations(Set<Litigation> litigations) {
        this.litigations = litigations;
    }
}
