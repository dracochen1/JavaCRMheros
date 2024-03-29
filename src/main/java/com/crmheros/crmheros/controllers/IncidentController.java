package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Incident;
import com.crmheros.crmheros.repositories.IncidentRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller to manage our incident (API, HTTP verbs)
 */

@RestController
@RequestMapping(path = "/incidents")
public class IncidentController {
    private final IncidentRepository incidentRepository;

    public IncidentController (IncidentRepository in)
    {
        this.incidentRepository = in;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Incident> getIncident ()
    {
        return incidentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Incident> getIncident (@PathVariable UUID id)
    {
        return incidentRepository.findById(id);
    }
    public static final class IncidentParams {
        public String type;
        public String description;
        public String location;
        public String source;
        public boolean alert;
        public boolean status;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Incident createIncident (@RequestBody IncidentController.IncidentParams params)
    {
        Incident c = new Incident();
        c.setType(params.type);
        c.setDescription(params.description);
        c.setLocation(params.location);
        c.setSource(params.source);
        c.setAlert(true);
        c.setStatus(true);
        incidentRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Incident updateIncident (@PathVariable UUID id, @RequestBody IncidentController.IncidentParams params)
    {
        Incident c = incidentRepository.findById(id).orElseThrow();
        c.setType(params.type);
        c.setDescription(params.description);
        c.setLocation(params.location);
        c.setSource(params.source);
        c.setAlert(params.alert);
        c.setStatus(params.status);
        incidentRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteIncident (@PathVariable UUID id)
    {
        Incident c = incidentRepository.findById(id).orElseThrow();
        incidentRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
