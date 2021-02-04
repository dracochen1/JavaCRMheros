package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Civil;

import com.crmheros.crmheros.repositories.CivilRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path="/civils")
public class CivilsController {
    private final CivilRepository civilRepository;

    public CivilsController (CivilRepository cr)
    {
        this.civilRepository = cr;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Civil> getCivils ()
    {
        return civilRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Civil> getCivil (@PathVariable UUID id)
    {
        return civilRepository.findById(id);
    }

    public static final class CivilParams {
        public String firstName;
        public String lastName;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Civil createCivil (@RequestBody CivilParams params)
    {
        Civil c = new Civil();
        c.setFirstName(params.firstName);
        c.setLastName(params.lastName);
        civilRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Civil updateCivil (@PathVariable UUID id, @RequestBody CivilParams params)
    {
        Civil c = civilRepository.findById(id).orElseThrow();
        c.setFirstName(params.firstName);
        c.setLastName(params.lastName);
        civilRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCivil (@PathVariable UUID id)
    {
        Civil c = civilRepository.findById(id).orElseThrow();
        civilRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
