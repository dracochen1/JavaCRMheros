package com.crmheros.crmheros.controllers;
import com.crmheros.crmheros.models.Litigation;
import com.crmheros.crmheros.repositories.LitigationRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to manage our litigation (API, HTTP verbs)
 */

@RestController
@RequestMapping(path = "/litiges")
public class LitigationController {
    private final LitigationRepository litigationRepository;

    public LitigationController(LitigationRepository in)
    {
        this.litigationRepository = in;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Litigation> getLitige ()
    {
        return litigationRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Litigation> getIncident (@PathVariable UUID id)
    {
        return litigationRepository.findById(id);
    }
    public static final class LitigeParams {
        public String object;
        public String type;
        public String relatedPersons;
        public String mission;
        public Integer cost;
        public String photo;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Litigation createIncident (@RequestBody LitigationController.LitigeParams params)
    {
        Litigation c = new Litigation();
        c.setObject(params.object);
        c.setType(params.type);
        c.setRelatedPersons(params.relatedPersons);
        c.setMission(params.mission);
        c.setCost(params.cost);
        c.setPhoto(params.photo);


        litigationRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Litigation updateLitige (@PathVariable UUID id, @RequestBody LitigationController.LitigeParams params)
    {
        Litigation c = litigationRepository.findById(id).orElseThrow();
        c.setObject(params.object);
        c.setType(params.type);
        c.setRelatedPersons(params.relatedPersons);
        c.setMission(params.mission);
        c.setCost(params.cost);
        c.setPhoto(params.photo);

        litigationRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteLitige (@PathVariable UUID id)
    {
        Litigation c = litigationRepository.findById(id).orElseThrow();
        litigationRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
