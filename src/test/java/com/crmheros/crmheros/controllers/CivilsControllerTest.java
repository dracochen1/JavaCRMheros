package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
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
        .andExpect(jsonPath("$.firstName").value("Naka"));
    }
}
