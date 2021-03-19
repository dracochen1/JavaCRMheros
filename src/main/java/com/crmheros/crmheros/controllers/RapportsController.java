package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Rapport;
import com.crmheros.crmheros.repositories.RapportRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/rapports")
public class RapportsController {
    private final RapportRepository rapportRepository;

    public RapportsController(RapportRepository rr) {
        this.rapportRepository = rr;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Rapport> getRapports() {
        return rapportRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Rapport> getRapport(@PathVariable UUID id) {
        return rapportRepository.findById(id);
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Rapport createRapport(@RequestBody RapportParams params) {
        Rapport r = new Rapport();
        r.setResponsible(params.responsible);
        r.setComment(params.comment);

        rapportRepository.save(r);
        return r;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Rapport updateRapport(@PathVariable UUID id, @RequestBody RapportParams params) {
        Rapport r = rapportRepository.findById(id).orElseThrow();
        r.setResponsible(params.responsible);
        r.setComment(params.comment);

        rapportRepository.save(r);
        return r;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable UUID id) {
        Rapport r = rapportRepository.findById(id).orElseThrow();
        rapportRepository.delete(r);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static final class RapportParams {
        public String responsible;
        public String comment;
    }
}
