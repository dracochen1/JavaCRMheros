package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "supers")
public class Super {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String name;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String power;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private String weakness;

    @Column(nullable = true)
    @JsonView(DetailView.class)
    private Integer score;

    @Column(nullable = true)
    @JsonView(DetailView.class)
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "civil_id", referencedColumnName = "id")
    private Civil civil;

    @ManyToOne
    @JsonView(ListView.class)
    private Satisfaction satisfaction;

    @ManyToOne
    @JsonView(ListView.class)
    private Mission mission;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Civil getCivil() {
        return civil;
    }

    public void setCivil(Civil civil) {
        this.civil = civil;
    }

    public Satisfaction getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Satisfaction satisfaction) {
        this.satisfaction = satisfaction;
    }
}
