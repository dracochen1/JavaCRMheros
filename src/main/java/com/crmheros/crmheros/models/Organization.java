package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String name;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String headOffice;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String headOfficer;

    @OneToMany(mappedBy = "organization")
    @JsonView(ListView.class)
    private Set<Civil> civils;

    @Column()
    @JsonView(ListView.class)
    private String comment;

    @Column()
    @JsonView(ListView.class)
    private String createdAt;

    @Column()
    @JsonView(ListView.class)
    private String updatedAt;

    @Column()
    @JsonView(ListView.class)
    private Integer numberOfIncidentsDeclared;

    @Column()
    @JsonView(ListView.class)
    private Integer numberOfAccidentsSuffered;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public String getHeadOfficer() { return headOfficer; }

    public void setHeadOfficer(String headOfficer) { this.headOfficer = headOfficer; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public Integer getNumberOfIncidentsDeclared() { return numberOfIncidentsDeclared; }

    public void setNumberOfIncidentsDeclared(Integer numberOfIncidentsDeclared) { this.numberOfIncidentsDeclared = numberOfIncidentsDeclared; }

    public Integer getNumberOfAccidentsSuffered() { return this.numberOfAccidentsSuffered; }

    public void setNumberOfAccidentsSuffered(Integer numberOfAccidentsSuffered) { this.numberOfAccidentsSuffered = numberOfAccidentsSuffered; }

    public Set<Civil> getCivils() {
        return civils;
    }

    public void setCivils(Set<Civil> civils) {
        this.civils = civils;
    }
}
