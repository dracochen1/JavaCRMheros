package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Civil;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CivilsControllerTest extends TestBase
{
    @Test
    public void TestUserCreation() throws Exception
    {
        this.mockMvc.perform(
                post("/civils/")
                    .content("{ \"firstName\": \"Naka\", \"lastName\": \"TheShiba\" }")
                    .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Naka"))
            .andExpect(jsonPath("$.lastName").value("TheShiba"));
    }

    @Test
    public void TestUserGet() throws Exception
    {
        Civil c = new Civil();
        c.setFirstName("Naka");
        c.setLastName("TheShiba");
        civilRepository.save(c);

        this.mockMvc.perform(
                get("/civils/" + c.getId().toString())
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Naka"))
            .andExpect(jsonPath("$.lastName").value("TheShiba"))
            .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestUserUpdate() throws Exception
    {
        Civil c = new Civil();
        c.setFirstName("Naka");
        c.setLastName("TheShiba");
        civilRepository.save(c);

        this.mockMvc.perform(
                patch("/civils/" + c.getId().toString())
                        .content("{ \"firstName\": \"StrongNaka\", \"lastName\": \"TheBestShiba\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("StrongNaka"))
            .andExpect(jsonPath("$.lastName").value("TheBestShiba"))
            .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestUserDelete() throws Exception
    {
        Civil c = new Civil();
        c.setFirstName("Naka");
        c.setLastName("TheShiba");
        civilRepository.save(c);

        this.mockMvc.perform(
                delete("/civils/" + c.getId().toString())
        )
            .andExpect(status().isOk());
    }
}
