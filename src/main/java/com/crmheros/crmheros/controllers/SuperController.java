package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Super;
import com.crmheros.crmheros.repositories.CivilRepository;
import com.crmheros.crmheros.repositories.OrganizationRepository;
import com.crmheros.crmheros.repositories.SuperRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/supers")
public class SuperController {
    private final SuperRepository superRepository;
    private final CivilRepository civilRepository;

    public SuperController (SuperRepository su, CivilRepository ci)
    {
        this.superRepository = su;
        this.civilRepository = ci;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Super> getSuper ()
    {
        return superRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Super> getSuper (@PathVariable UUID id)
    {
        return superRepository.findById(id);
    }

    public static final class SuperParams {
        public String name;
        public String power;
        public String weakness;
        public Integer score;
        public String comment;
        public UUID civil;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Super createSuper (@RequestBody SuperController.SuperParams params)
    {
        var civil = civilRepository.findById(params.civil).orElseThrow();
        Super c = new Super();
        c.setName(params.name);
        c.setPower(params.power);
        c.setWeakness(params.weakness);
        c.setScore(params.score);
        c.setComment(params.comment);
        c.setCivil(civil);

        superRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Super updateSuper (@PathVariable UUID id, @RequestBody SuperController.SuperParams params)
    {
        Super c = superRepository.findById(id).orElseThrow();
        c.setName(params.name);
        c.setPower(params.power);
        c.setWeakness(params.weakness);
        c.setScore(params.score);
        c.setComment(params.comment);

        superRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSuper (@PathVariable UUID id)
    {
        Super c = superRepository.findById(id).orElseThrow();
        superRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //test
}
