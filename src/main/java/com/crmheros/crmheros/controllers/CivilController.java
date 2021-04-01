package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Civil;

import com.crmheros.crmheros.models.Role;
import com.crmheros.crmheros.models.RoleStatus;
import com.crmheros.crmheros.repositories.CivilRepository;

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
@RequestMapping(path="/civils")
public class CivilController {
    private final CivilRepository civilRepository;

    private final OrganizationRepository organizationRepository;

    public CivilController(CivilRepository cr, OrganizationRepository or)
    {
        this.civilRepository = cr;
        this.organizationRepository = or;
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
        public String civility;
        public String password;
        public String address;
        public String mail;
        public Integer phone;
        public String dateOfBirth;
        public String dateOfDeath;
        public String comment;
        public String dateAdded;
        public String lastModificationDate;
        public String role;
        public UUID organization;
        public Integer numberOfIncidentsDeclared;
        public Integer numberOfAccidentsSuffered;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Civil createCivil (@RequestBody CivilParams params)
    {
        var orga = organizationRepository.findById(params.organization).orElseThrow();
        Civil c = new Civil();
        c.setFirstName(params.firstName);
        c.setLastName(params.lastName);
        c.setCivility(params.civility);
        c.setPassword(params.password);
        c.setAddress(params.address);
        c.setMail(params.mail);
        c.setPhone(params.phone);
        c.setDateOfBirth(params.dateOfBirth);
        c.setDateOfDeath(params.dateOfDeath);
        c.setComment(params.comment);
        c.setDateAdded(params.dateAdded);
        c.setLastModificationDate(params.lastModificationDate);
        c.setNumberOfIncidentsDeclared(params.numberOfIncidentsDeclared);
        c.setNumberOfAccidentsSuffered(params.numberOfAccidentsSuffered);
        c.setOrganization(orga);

        Role r = new Role();
        r.setCivil(c);
        r.setRole(RoleStatus.employee);
        r.setActif(true);
        r.setCreatedAt(new Date());

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
        c.setCivility(params.civility);
        c.setPassword(params.password);
        c.setAddress(params.address);
        c.setMail(params.mail);
        c.setPhone(params.phone);
        c.setDateOfBirth(params.dateOfBirth);
        c.setDateOfDeath(params.dateOfDeath);
        c.setComment(params.comment);
        c.setDateAdded(params.dateAdded);
        c.setLastModificationDate(params.lastModificationDate);
        c.setNumberOfIncidentsDeclared(params.numberOfIncidentsDeclared);
        c.setNumberOfAccidentsSuffered(params.numberOfAccidentsSuffered);

        civilRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public ResponseEntity<Void> deleteCivil (@PathVariable UUID id)
    {
        Civil c = civilRepository.findById(id).orElseThrow();
        civilRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
