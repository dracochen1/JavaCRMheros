package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "civils")
public class Civil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String firstName;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String lastName;

    @Column()
    @JsonView(ListView.class)
    private String password;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String civility;

    @Column()
    @JsonView(ListView.class)
    private String address;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String mail;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private Integer phone;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String dateOfBirth;

    @Column()
    @JsonView(ListView.class)
    private String dateOfDeath;

    @Column()
    @JsonView(ListView.class)
    private String comment;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String dateAdded;

    @Column()
    @JsonView(ListView.class)
    private String lastModificationDate;

    @Column()
    @JsonView(ListView.class)
    private Integer numberOfIncidentsDeclared;

    @Column()
    @JsonView(ListView.class)
    private Integer numberOfAccidentsSuffered;

    @ManyToOne
    @JsonBackReference
    @JsonView(ListView.class)
    private Organization organization;

    @OneToMany(mappedBy="civil", fetch=FetchType.EAGER)
    @JsonManagedReference
    @JsonView(ListView.class)
    public Set<Role> roles;

    @OneToOne(mappedBy = "civil")
    @JsonBackReference
    @JsonView(ListView.class)
    private Super supers;

    @OneToMany(mappedBy = "civils", cascade = CascadeType.ALL)
    @JsonView(ListView.class)
    private Set<Incident> incidents;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return this.dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getLastModificationDate() {
        return this.lastModificationDate;
    }

    public void setLastModificationDate(String lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Integer getNumberOfIncidentsDeclared() {
        return this.numberOfIncidentsDeclared;
    }

    public void setNumberOfIncidentsDeclared(Integer numberOfIncidentsDeclared) {
        this.numberOfIncidentsDeclared = numberOfIncidentsDeclared;
    }

    public Integer getNumberOfAccidentsSuffered() {
        return this.numberOfAccidentsSuffered;
    }

    public void setNumberOfAccidentsSuffered(Integer numberOfAccidentsSuffered) {
        this.numberOfAccidentsSuffered = numberOfAccidentsSuffered;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Super getSupers() {
        return supers;
    }

    public void setSupers(Super supers) {
        this.supers = supers;
    }

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
