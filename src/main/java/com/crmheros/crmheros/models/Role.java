package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private Boolean actif;

    @Column()
    @JsonView(ListView.class)
    private Date createdAt;

    @Column()
    @JsonView(ListView.class)
    private Date enddAt;

    @Column()
    @JsonView(ListView.class)
    private RoleStatus role;

    @JsonBackReference
    @ManyToOne
    @JsonView(ListView.class)
    private Civil civil;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getEnddAt() {
        return enddAt;
    }

    public void setEnddAt(Date enddAt) {
        this.enddAt = enddAt;
    }

    public Civil getCivil() {
        return civil;
    }

    public void setCivil(Civil civil) {
        this.civil = civil;
    }

    public RoleStatus getRole() {
        return role;
    }

    public void setRole(RoleStatus role) {
        this.role = role;
    }
}
