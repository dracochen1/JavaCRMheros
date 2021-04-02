package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Crisis;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CrisisControllerTest extends TestBase{
    @Test
    public void TestCriseCreation() throws Exception
    {
        this.mockMvc.perform(
                post("/crises/")
                        .content("{ \"type\": \"Bomb in LA\", \"description\": \"A bomb exploded near the Los Angeles city hall. A victim complains about our superhero who had to abandon his son to save the mayor\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Bomb in LA"))
                .andExpect(jsonPath("$.description").value("A bomb exploded near the Los Angeles city hall. A victim complains about our superhero who had to abandon his son to save the mayor"));
    }

    @Test
    public void TestCriseGet() throws Exception
    {
        Crisis c = new Crisis();
        c.setType("Bomb in LA");
        c.setDescription("A victim complains about our superhero who had to abandon his son to save the mayor");
        crisisRepository.save(c);

        this.mockMvc.perform(
                get("/crises/" + c.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Bomb in LA"))
                .andExpect(jsonPath("$.description").value("A victim complains about our superhero who had to abandon his son to save the mayor"))
                .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestCriseUpdate() throws Exception
    {
        Crisis c = new Crisis();
        c.setType("Bomb in LA");
        c.setDescription("A victim complains about our superhero who had to abandon his son to save the mayor");
        crisisRepository.save(c);

        this.mockMvc.perform(
                patch("/crises/" + c.getId().toString())
                        .content("{ \"type\": \"Fail in LA\", \"description\": \"A victim complains about our superhero who had to abandon his son to save the mayor. He certainly could have saved the boy\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Fail in LA"))
                .andExpect(jsonPath("$.description").value("A victim complains about our superhero who had to abandon his son to save the mayor. He certainly could have saved the boy"))
                .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestCriseDelete() throws Exception
    {
        Crisis c = new Crisis();
        c.setType("Bomb in LA");
        c.setDescription("A victim complains about our superhero who had to abandon his son to save the mayor");
        crisisRepository.save(c);

        this.mockMvc.perform(
                delete("/crises/" + c.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
