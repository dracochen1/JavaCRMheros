package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Rapport;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RapportsControllerTest extends TestBase
{
    @Test
    public void TestRapportCreation() throws Exception
    {
        this.mockMvc.perform(
                post("/rapports/")
                        .content("{ \"responsible\": \"Jules Cano\", \"fkIdMission\": \"3\", \"fkIdCrise\": \"1\", \"comment\": \"Très mécontent\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responsible").value("Jules Cano"))
                .andExpect(jsonPath("$.comment").value("Très mécontent"))
                .andExpect(jsonPath("$.fkIdMission").value("3"))
                .andExpect(jsonPath("$.fkIdCrise").value("1"));
    }

    @Test
    public void TestRapportGet() throws Exception {
        Rapport r = new Rapport();
        r.setResponsible("Jules Cano");
        r.setComment("Très mécontent");
        r.setFkIdMission(3);
        r.setFkIdCrise(1);
        rapportRepository.save(r);

        this.mockMvc.perform(
                get("/rapports/" + r.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responsible").value("Jules Cano"))
                .andExpect(jsonPath("$.comment").value("Très mécontent"))
                .andExpect(jsonPath("$.fkIdMission").value("3"))
                .andExpect(jsonPath("$.fkIdCrise").value("1"))
                .andExpect(jsonPath("$.id").value(r.getId().toString()));
    }

    @Test
    public void TestRapportUpdate() throws Exception {
        Rapport r = new Rapport();
        r.setResponsible("Jules Carno");
        r.setComment("Très mécontent");
        r.setFkIdMission(3);
        r.setFkIdCrise(1);
        rapportRepository.save(r);

        this.mockMvc.perform(
                patch("/rapports/" + r.getId().toString())
                        .content("{ \"responsible\": \"Poulevorde\", \"fkIdMission\": \"4\", \"fkIdCrise\": \"2\", \"comment\": \"personne agressive\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responsible").value("Poulevorde"))
                .andExpect(jsonPath("$.comment").value("personne agressive"))
                .andExpect(jsonPath("$.fkIdMission").value("4"))
                .andExpect(jsonPath("$.fkIdCrise").value("2"))
                .andExpect(jsonPath("$.id").value(r.getId().toString()));
    }

    @Test
    public void TestRapportDelete() throws Exception {
        Rapport r = new Rapport();
        r.setResponsible("Poulevorde");
        r.setComment("Très mécontent");
        r.setFkIdMission(3);
        r.setFkIdCrise(1);
        rapportRepository.save(r);

        this.mockMvc.perform(
                delete("/rapports/" + r.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
