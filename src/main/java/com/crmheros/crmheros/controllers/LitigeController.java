package com.crmheros.crmheros.controllers;
import com.crmheros.crmheros.models.Litige;
import com.crmheros.crmheros.repositories.LitigeRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/litiges")
public class LitigeController {
    private final LitigeRepository litigeRepository;

    public LitigeController(LitigeRepository in)
    {
        this.litigeRepository = in;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Litige> getLitige ()
    {
        return litigeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Litige> getIncident (@PathVariable UUID id)
    {
        return litigeRepository.findById(id);
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
    public Litige createIncident (@RequestBody LitigeController.LitigeParams params)
    {
        Litige c = new Litige();
        c.setObject(params.object);
        c.setType(params.type);
        c.setRelatedPersons(params.relatedPersons);
        c.setMission(params.mission);
        c.setCost(params.cost);
        c.setPhoto(params.photo);


        litigeRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Litige updateLitige (@PathVariable UUID id, @RequestBody LitigeController.LitigeParams params)
    {
        Litige c = litigeRepository.findById(id).orElseThrow();
        c.setObject(params.object);
        c.setType(params.type);
        c.setRelatedPersons(params.relatedPersons);
        c.setMission(params.mission);
        c.setCost(params.cost);
        c.setPhoto(params.photo);

        litigeRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteLitige (@PathVariable UUID id)
    {
        Litige c = litigeRepository.findById(id).orElseThrow();
        litigeRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
