package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Report;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReportControllerTest extends TestBase
{
    @Test
    public void TestRapportCreation() throws Exception
    {
        this.mockMvc.perform(
                post("/rapports/")
                        .content("{ \"responsible\": \"Jules Cano\", \"comment\": \"Très mécontent\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responsible").value("Jules Cano"))
                .andExpect(jsonPath("$.comment").value("Très mécontent"));
    }

    @Test
    public void TestRapportGet() throws Exception {
        Report r = new Report();
        r.setResponsible("Jules Cano");
        r.setComment("Très mécontent");
        reportRepository.save(r);

        this.mockMvc.perform(
                get("/rapports/" + r.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responsible").value("Jules Cano"))
                .andExpect(jsonPath("$.comment").value("Très mécontent"))
                .andExpect(jsonPath("$.id").value(r.getId().toString()));
    }

    @Test
    public void TestRapportUpdate() throws Exception {
        Report r = new Report();
        r.setResponsible("Jules Carno");
        r.setComment("Très mécontent");
        reportRepository.save(r);

        this.mockMvc.perform(
                patch("/rapports/" + r.getId().toString())
                        .content("{ \"responsible\": \"Poulevorde\", \"comment\": \"personne agressive\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responsible").value("Poulevorde"))
                .andExpect(jsonPath("$.comment").value("personne agressive"))
                .andExpect(jsonPath("$.id").value(r.getId().toString()));
    }

    @Test
    public void TestRapportDelete() throws Exception {
        Report r = new Report();
        r.setResponsible("Poulevorde");
        r.setComment("Très mécontent");
        reportRepository.save(r);

        this.mockMvc.perform(
                delete("/rapports/" + r.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
