package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "missions")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String titre;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String nature;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String road;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String severitylevel;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String emergencylevel;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String status;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private Integer nombercivils;

    @Column()
    @JsonView(DetailView.class)
    private String startdate;

    @Column()
    @JsonView(DetailView.class)
    private String enddate;

    @ManyToOne
    @JsonView(ListView.class)
    private Incident incident;

    @OneToMany(mappedBy = "mission")
    @JsonView(ListView.class)
    private Set<Super> supers;

    @OneToMany(mappedBy = "mission")
    @JsonView(ListView.class)
    private Set<Rapport> rapports;

    @OneToMany(mappedBy = "mission")
    @JsonView(ListView.class)
    private Set<Crise> crises;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSeveritylevel() {
        return severitylevel;
    }

    public void setSeveritylevel(String severitylevel) {
        this.severitylevel = severitylevel;
    }

    public String getEmergencylevel() {
        return emergencylevel;
    }

    public void setEmergencylevel(String emergencylevel) {
        this.emergencylevel = emergencylevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNombercivils() {
        return nombercivils;
    }

    public void setNombercivils(int nombercivils) {
        this.nombercivils = nombercivils;
    }

    public Set<Super> getSupers() {
        return supers;
    }

    public void setSupers(Set<Super> supers) {
        this.supers = supers;
    }
}