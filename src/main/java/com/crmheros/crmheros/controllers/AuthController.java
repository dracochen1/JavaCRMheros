package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Civil;
import com.crmheros.crmheros.repositories.CivilRepository;
import com.crmheros.crmheros.views.DetailView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private CivilRepository civilRepository;

    @RequestMapping(
            value = "/login",
            method = {RequestMethod.GET, RequestMethod.PUT})
    @JsonView(DetailView.class)
    public Civil loginCivil(@PathVariable("id") UUID id) throws Exception {
        return civilRepository.findById(id).map(civil -> {
            return civil;
        }).orElseThrow(() -> new Exception("Le civil avec l'id " + id + " n'a pas été trouvé dans la database."));
    }
}