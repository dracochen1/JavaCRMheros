package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Organization;

import com.crmheros.crmheros.repositories.OrganizationRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/organizations")
class OrganizationsController {
    private final OrganizationRepository organizationRepository;

    public OrganizationsController(OrganizationRepository or) {

        this.organizationRepository = or;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Organization> getOrganizations() {

        return organizationRepository.findAll();
    }

    @GetMapping("/count")
    private Long getNumberOfOrganization(){
        return organizationRepository.count();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Organization> getOrganization(@PathVariable UUID id) {
        return organizationRepository.findById(id);
    }

    public static final class OrganizationParams {
        public String name;
        public String headOffice;
        public String headOfficer;
        public String comment;
        public Date createdAt;
        public Date updatedAt;
        public Integer numberOfIncidentsDeclared;
        public Integer numberOfAccidentsSuffered;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Organization createOrganization(@RequestBody OrganizationParams params) {
        Organization o = new Organization();
        o.setName(params.name);
        o.setHeadOffice(params.headOffice);
        o.setHeadOfficer(params.headOfficer);
        o.setComment(params.comment);
        o.setCreatedAt(params.createdAt);
        o.setUpdatedAt(params.updatedAt);
        o.setNumberOfIncidentsDeclared(params.numberOfIncidentsDeclared);
        o.setNumberOfAccidentsSuffered(params.numberOfAccidentsSuffered);

        organizationRepository.save(o);

        return o;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Organization updateOrganization(@PathVariable UUID id, @RequestBody OrganizationParams params) {
        Organization o = organizationRepository.findById(id).orElseThrow();
        o.setName(params.name);
        o.setHeadOffice(params.headOffice);
        o.setHeadOfficer(params.headOfficer);
        o.setComment(params.comment);
        o.setCreatedAt(params.createdAt);
        o.setUpdatedAt(params.updatedAt);
        o.setNumberOfIncidentsDeclared(params.numberOfIncidentsDeclared);
        o.setNumberOfAccidentsSuffered(params.numberOfAccidentsSuffered);
        o.setHeadOfficer(params.headOfficer);

        organizationRepository.save(o);

        return o;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable UUID id) {
        Organization o = organizationRepository.findById(id).orElseThrow();
        organizationRepository.delete(o);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
