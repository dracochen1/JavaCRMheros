package com.crmheros.crmheros.models;

import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "satisfactions")
public class Satisfaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @JsonView(ListView.class)
    private UUID id;

    @Column(nullable = false)
    @JsonView(DetailView.class)
    private Integer phone;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String mail;

    @Column()
    @JsonView(ListView.class)
    private Integer fk_super;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String comment;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private Integer score;

    @Column(nullable = false)
    @JsonView(ListView.class)
    private String source;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getFk_super() {
        return fk_super;
    }

    public void setFk_super(Integer fk_super) {
        this.fk_super = fk_super;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
