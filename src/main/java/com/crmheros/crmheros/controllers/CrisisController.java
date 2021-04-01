package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Crisis;

import com.crmheros.crmheros.repositories.CrisisRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path="/crises")
public class CrisisController {
    private final CrisisRepository crisisRepository;

    public CrisisController(CrisisRepository cr)
    {
        this.crisisRepository = cr;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Crisis> getCrises ()
    {
        return crisisRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Crisis> getCrise (@PathVariable UUID id)
    {
        return crisisRepository.findById(id);
    }

    public static final class CriseParams {
        public String type;
        public String description;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Crisis createCrise (@RequestBody CrisisController.CriseParams params)
    {
        Crisis c = new Crisis();
        c.setType(params.type);
        c.setDescription(params.description);

        crisisRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Crisis updateCrise (@PathVariable UUID id, @RequestBody CrisisController.CriseParams params)
    {
        Crisis c = crisisRepository.findById(id).orElseThrow();
        c.setType(params.type);
        c.setDescription(params.description);

        crisisRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCrise (@PathVariable UUID id)
    {
        Crisis c = crisisRepository.findById(id).orElseThrow();
        crisisRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
