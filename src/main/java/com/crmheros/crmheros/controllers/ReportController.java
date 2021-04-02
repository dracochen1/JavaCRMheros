package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Report;
import com.crmheros.crmheros.repositories.ReportRepository;
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
public class ReportController {
    private final ReportRepository reportRepository;

    public ReportController(ReportRepository rr) {
        this.reportRepository = rr;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Report> getReports() {
        return reportRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Report> getReport(@PathVariable UUID id) {
        return reportRepository.findById(id);
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Report createReport(@RequestBody ReportParams params) {
        Report r = new Report();
        r.setResponsible(params.responsible);
        r.setComment(params.comment);

        reportRepository.save(r);
        return r;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Report updateReport(@PathVariable UUID id, @RequestBody ReportParams params) {
        Report r = reportRepository.findById(id).orElseThrow();
        r.setResponsible(params.responsible);
        r.setComment(params.comment);

        reportRepository.save(r);
        return r;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable UUID id) {
        Report r = reportRepository.findById(id).orElseThrow();
        reportRepository.delete(r);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static final class ReportParams {
        public String responsible;
        public String comment;
    }
}
