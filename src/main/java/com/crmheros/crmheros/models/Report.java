package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "rapports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String responsible;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String comment;

    @ManyToOne
    @JsonView(ListView.class)
    private Mission mission;

    @OneToMany(mappedBy = "report")
    @JsonView(ListView.class)
    private Set<Satisfaction> satisfactions;

    @OneToMany(mappedBy = "report")
    @JsonView(ListView.class)
    private Set<Crisis> crises;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Satisfaction> getSatisfactions() {
        return satisfactions;
    }

    public void setSatisfactions(Set<Satisfaction> satisfactions) {
        this.satisfactions = satisfactions;
    }
}
