package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Civil;
import com.crmheros.crmheros.repositories.CivilRepository;
import com.crmheros.crmheros.views.DetailView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private CivilRepository civilRepository;


    @GetMapping(path = "/login/{mail}")
    @JsonView(DetailView.class)
    public Civil loginCivil(@PathVariable("mail") String mail) throws Exception {

        return civilRepository.findByMail(mail)
                .orElseThrow(() -> new Exception("Le civil avec l'identifiant de service " + mail + " n'a pas été trouvé dans la database."));
    }
}