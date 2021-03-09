package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Super;
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
@RequestMapping(path = "/super")
public class SuperController {
    private final SuperRepository superRepository;

    public SuperController (SuperRepository su)
    {
        this.superRepository = su;
    }

    @GetMapping(path = "/super")
    @JsonView(ListView.class)
    public Iterable<Super> getSuper ()
    {
        return superRepository.findAll();
    }

    @GetMapping(path = "/super/{id}")
    @JsonView(DetailView.class)
    public Optional<Super> getSuper (@PathVariable UUID id)
    {
        return superRepository.findById(id);
    }

    public static final class SuperParams {
        public String name;
        public String secretIdentity;
        public String power;
        public String weakness;
        public Integer score;
        public String comment;
    }

    @PostMapping(path = "/super")
    @JsonView(DetailView.class)
    public Super createSuper (@RequestBody SuperController.SuperParams params)
    {
        Super c = new Super();
        c.setName(params.name);
        c.setSecretIdentity(params.secretIdentity);
        c.setPower(params.power);
        c.setWeakness(params.weakness);
        c.setScore(params.score);
        c.setComment(params.comment);

        superRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/super/{id}")
    @JsonView(DetailView.class)
    public Super updateSuper (@PathVariable UUID id, @RequestBody SuperController.SuperParams params)
    {
        Super c = superRepository.findById(id).orElseThrow();
        c.setName(params.name);
        c.setSecretIdentity(params.secretIdentity);
        c.setPower(params.power);
        c.setWeakness(params.weakness);
        c.setScore(params.score);
        c.setComment(params.comment);

        superRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/super/{id}")
    public ResponseEntity<Void> deleteSuper (@PathVariable UUID id)
    {
        Super c = superRepository.findById(id).orElseThrow();
        superRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //test
}
