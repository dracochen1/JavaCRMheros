package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.models.Mission;

import com.crmheros.crmheros.repositories.MissionRepository;
import com.crmheros.crmheros.views.DetailView;
import com.crmheros.crmheros.views.ListView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/missions")
class MissionController {
    private final MissionRepository missionRepository;

    public MissionController(MissionRepository or) {

        this.missionRepository = or;
    }

    @GetMapping(path = "/")
    @JsonView(ListView.class)
    public Iterable<Mission> getMissions() {

        return missionRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Optional<Mission> getMission(@PathVariable UUID id) {
        return missionRepository.findById(id);
    }

    public static final class MissionParams {
        public String titre;
        public String nature;
        public String road;
        public String severitylevel;
        public String emergencylevel;
        public String superheros;
        public String supervilain;
        public String status;
        public Integer nombercivils;
        public String startdate;
        public String enddate;
    }

    @PostMapping(path = "/")
    @JsonView(DetailView.class)
    public Mission createMission(@RequestBody MissionController.MissionParams params) {
        Mission o = new Mission();
        o.setTitre(params.titre);
        o.setNature(params.nature);
        o.setRoad(params.road);
        o.setSeveritylevel(params.severitylevel);
        o.setEmergencylevel(params.emergencylevel);
        o.setSuperheros(params.superheros);
        o.setSupervilain(params.supervilain);
        o.setStatus(params.status);
        o.setNombercivils(params.nombercivils);

        missionRepository.save(o);

        return o;
    }

    @PatchMapping(path = "/{id}")
    @JsonView(DetailView.class)
    public Mission updateOrganization(@PathVariable UUID id, @RequestBody MissionController.MissionParams params) {
        Mission o = missionRepository.findById(id).orElseThrow();
        o.setTitre(params.titre);
        o.setNature(params.nature);
        o.setRoad(params.road);
        o.setSeveritylevel(params.severitylevel);
        o.setEmergencylevel(params.emergencylevel);
        o.setSuperheros(params.superheros);
        o.setSupervilain(params.supervilain);
        o.setStatus(params.status);
        o.setNombercivils(params.nombercivils);

        missionRepository.save(o);

        return o;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable UUID id) {
        Mission o = missionRepository.findById(id).orElseThrow();
        missionRepository.delete(o);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}


