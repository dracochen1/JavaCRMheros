package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Incident;
import com.crmheros.crmheros.repositories.IncidentRepository;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IncidentControllerTest extends TestBase {
    @Test
    public void TestIncidentCreation() throws Exception{
        this.mockMvc.perform(
                post("/incident/")
                        .content("{ \"type\": \"Attaque d'un super-vilain\", \"description\": \"Un super vilain vient d'attaquer la ville de New-York\", \"location\": \"New-York(USA)\", \"source\" : \"Tony Stark\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Attaque d'un super-vilain"))
                .andExpect(jsonPath("$.description").value("Un super vilain vient d'attaquer la ville de New-York"))
                .andExpect(jsonPath("$.location").value("New-York(USA)"))
                .andExpect(jsonPath("$.source").value("Tony Stark"));
    }
    @Test
    public void TestIncidentGet() throws Exception
    {
        Incident i = new Incident();
        i.setType("Attaque d'un super-vilain");
        i.setDescription("Un super vilain vient d'attaquer la ville de New-York");
        i.setLocation("New-York(USA)");
        i.setSource("Tony Stark");
        incidentRepository.save(i);

        this.mockMvc.perform(
                get("/incident/" + i.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Attaque d'un super-vilain"))
                .andExpect(jsonPath("$.description").value("Un super vilain vient d'attaquer la ville de New-York"))
                .andExpect(jsonPath("$.location").value("New-York(USA)"))
                .andExpect(jsonPath("$.source").value("Tony Stark"))
                .andExpect(jsonPath("$.id").value(i.getId().toString()));
    }

    @Test
    public void TestIncidentUpdate() throws Exception
    {
        Incident i = new Incident();
        i.setType("Attaque d'un super-vilain");
        i.setDescription("Un super vilain vient d'attaquer la ville de New-York");
        i.setLocation("New-York(USA)");
        i.setSource("Tony Stark");
        incidentRepository.save(i);

        this.mockMvc.perform(
                patch("/incident/" + i.getId().toString())
                        .content("{ \"type\": \"Terroriste\", \"description\": \"Une bombe a explosé\", \"location\": \"Los angeles(USA)\", \"source\" : \"Président des USA\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Terroriste"))
                .andExpect(jsonPath("$.description").value("Une bombe a explosé"))
                .andExpect(jsonPath("$.location").value("Los angeles(USA)"))
                .andExpect(jsonPath("$.source").value("Président des USA"))
                .andExpect(jsonPath("$.id").value(i.getId().toString()));
    }
    @Test
    public void TestIncidentDelete() throws Exception{
        Incident i = new Incident();
        i.setType("Attaque d'un super-vilain");
        i.setDescription("Un super vilain vient d'attaquer la ville de New-York");
        i.setLocation("New-York(USA)");
        i.setSource("Tony Stark");
        incidentRepository.save(i);

        this.mockMvc.perform(
                delete("/incident/" + i.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
