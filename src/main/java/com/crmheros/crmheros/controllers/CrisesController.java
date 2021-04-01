package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Crise;

import com.crmheros.crmheros.repositories.CriseRepository;
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
public class CrisesController {
    private final CriseRepository criseRepository;

    public CrisesController (CriseRepository cr)
    {
        this.criseRepository = cr;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Crise> getCrises ()
    {
        return criseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Crise> getCrise (@PathVariable UUID id)
    {
        return criseRepository.findById(id);
    }

    public static final class CriseParams {
        public String type;
        public String description;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Crise createCrise (@RequestBody CrisesController.CriseParams params)
    {
        Crise c = new Crise();
        c.setType(params.type);
        c.setDescription(params.description);

        criseRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Crise updateCrise (@PathVariable UUID id, @RequestBody CrisesController.CriseParams params)
    {
        Crise c = criseRepository.findById(id).orElseThrow();
        c.setType(params.type);
        c.setDescription(params.description);

        criseRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCrise (@PathVariable UUID id)
    {
        Crise c = criseRepository.findById(id).orElseThrow();
        criseRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
