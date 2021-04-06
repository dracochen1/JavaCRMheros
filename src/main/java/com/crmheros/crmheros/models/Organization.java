package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
import java.util.Set;
import java.util.Date;

/**
 * Organizational model, to be as close as possible to our partners
 */
@Entity(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String name;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String headOffice;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String headOfficer;

    @Column()
    @JsonView(ListView.class)
    private String comment;

    @Column()
    @JsonView(ListView.class)
    private Date createdAt;

    @Column()
    @JsonView(ListView.class)
    private Date updatedAt;

    @Column()
    @JsonView(ListView.class)
    private Integer numberOfIncidentsDeclared;

    @Column()
    @JsonView(ListView.class)
    private Integer numberOfAccidentsSuffered;

    @OneToMany(mappedBy = "organization")
    @JsonManagedReference
    @JsonView(DetailView.class)
    private Set<Civil> civils;

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

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

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
