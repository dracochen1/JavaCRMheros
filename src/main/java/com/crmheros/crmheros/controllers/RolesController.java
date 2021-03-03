package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Role;
import com.crmheros.crmheros.repositories.RoleRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/roles")
class RolesController {
    private final RoleRepository roleRepository;

    public RolesController(RoleRepository or) {

        this.roleRepository = or;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Role> getRoles() {

        return roleRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Role> getRoles(@PathVariable UUID id)
    {
        return roleRepository.findById(id);
    }

    public static final class RoleParams {
        public String name;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Role createRole (@RequestBody RolesController.RoleParams params)
    {
        Role c = new Role();
        c.setName(params.name);

        roleRepository.save(c);
        return c;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Role updateRole (@PathVariable UUID id, @RequestBody RolesController.RoleParams params)
    {
        Role c = roleRepository.findById(id).orElseThrow();

        c.setName(params.name);

        roleRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteRole (@PathVariable UUID id)
    {
        Role c = roleRepository.findById(id).orElseThrow();
        roleRepository.delete(c);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

