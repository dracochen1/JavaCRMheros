package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Super;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SuperControllerTest extends TestBase {
    @Test
    public void TestSuperCreation() throws Exception{
        this.mockMvc.perform(
                post("/super/")
                        .content("{ \"name\": \"Iron-man\", \"secretIdentity\": \"Tony Stark\", \"power\": \"Son armure\", \"weakness\" : \"Attaque radiale\", \"score\" : 10, \"comment\": \"...\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Iron-man"))
                .andExpect(jsonPath("$.secretIdentity").value("Tony Stark"))
                .andExpect(jsonPath("$.power").value("Son armure"))
                .andExpect(jsonPath("$.weakness").value("Attaque radiale"))
                .andExpect(jsonPath("$.score").value(10))
                .andExpect(jsonPath("$.comment").value("..."));
    }

    @Test
    public void TestIncidentGet() throws Exception{
        Super s = new Super();
        s.setName("Iron-man");
        s.setPower("Son armure");
        s.setWeakness("Attaque radiale");
        s.setScore(10);
        s.setComment("...");
        superRepository.save(s);

        this.mockMvc.perform(
                get("/super/" + s.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Iron-man"))
                .andExpect(jsonPath("$.secretIdentity").value("Tony Stark"))
                .andExpect(jsonPath("$.power").value("Son armure"))
                .andExpect(jsonPath("$.weakness").value("Attaque radiale"))
                .andExpect(jsonPath("$.score").value(10))
                .andExpect(jsonPath("$.comment").value("..."));

    }

    @Test
    public void TestIncidentUpdate() throws Exception{
        Super s = new Super();
        s.setName("Iron-man");
        s.setPower("Son armure");
        s.setWeakness("Attaque radiale");
        s.setScore(10);
        s.setComment("...");
        superRepository.save(s);

        this.mockMvc.perform(
                patch("/super/" + s.getId().toString())
                .content("{ \"name\": \"Hulk\", \"secretIdentity\": \"Bruce Banner\", \"power\": \"Une force extraordinaire et une résitance incroyable\", \"weakness\" : \"Forme humaine\", \"score\" : 10, \"comment\": \"...\"}")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Hulk"))
                .andExpect(jsonPath("$.secretIdentity").value("Bruce Banner"))
                .andExpect(jsonPath("$.power").value("Une force extraordinaire et une résitance incroyable"))
                .andExpect(jsonPath("$.weakness").value("Forme humaine"))
                .andExpect(jsonPath("$.score").value(10))
                .andExpect(jsonPath("$.comment").value("..."));

    }
    @Test
    public void TestIncidentDelete() throws Exception{
        Super s = new Super();
        s.setName("Iron-man");
        s.setPower("Son armure");
        s.setWeakness("Attaque radiale");
        s.setScore(10);
        s.setComment("...");
        superRepository.save(s);

        this.mockMvc.perform(
                delete("/super/" + s.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
