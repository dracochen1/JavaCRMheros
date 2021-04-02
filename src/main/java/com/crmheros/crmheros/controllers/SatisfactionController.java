package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Satisfaction;
import com.crmheros.crmheros.repositories.SatisfactionRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/satisfactions")
public class SatisfactionController {
    private final SatisfactionRepository satisfactionRepository;

    public SatisfactionController(SatisfactionRepository sr) {
        this.satisfactionRepository = sr;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Satisfaction> getSatisfactions() {
        return satisfactionRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Satisfaction> getSatisfaction(@PathVariable UUID id) {
        return satisfactionRepository.findById(id);
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Satisfaction createSatisfaction(@RequestBody SatisfactionController.SatisfactionParams params) {
        Satisfaction s = new Satisfaction();
        s.setPhone(params.phone);
        s.setMail(params.mail);
        s.setComment(params.comment);
        s.setScore(params.score);
        s.setSource(params.source);

        satisfactionRepository.save(s);

        return s;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Satisfaction updateSatisfaction(@PathVariable UUID id, @RequestBody SatisfactionController.SatisfactionParams params) {
        Satisfaction s = satisfactionRepository.findById(id).orElseThrow();
        s.setPhone(params.phone);
        s.setMail(params.mail);
        s.setComment(params.comment);
        s.setScore(params.score);
        s.setSource(params.source);

        satisfactionRepository.save(s);

        return s;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSatisfaction(@PathVariable UUID id) {
        Satisfaction s = satisfactionRepository.findById(id).orElseThrow();
        satisfactionRepository.delete(s);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static final class SatisfactionParams {
        public Integer phone;
        public String mail;
        public String comment;
        public Integer score;
        public String source;
    }
}
