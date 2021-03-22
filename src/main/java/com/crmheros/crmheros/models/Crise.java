package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "crises")
public class Crise {
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
    private Rapport rapport;

    @ManyToOne
    @JsonView(ListView.class)
    private Mission mission;

    @OneToMany(mappedBy = "crise")
    @JsonView(ListView.class)
    private Set<Litige> litiges;

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

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }

    public Set<Litige> getLitiges() {
        return litiges;
    }

    public void setLitiges(Set<Litige> litiges) {
        this.litiges = litiges;
    }
}
