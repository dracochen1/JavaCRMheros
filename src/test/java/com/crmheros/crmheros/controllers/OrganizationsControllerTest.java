package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrganizationsControllerTest extends TestBase
{
    @Test
    public void TestOrganizationsCreation() throws Exception
    {
        this.mockMvc.perform(
                post("/organizations/")
                        .content("{ \"name\": \"Google\", \"headOffice\": \"California\", \"headOfficer\": \"Sundar Pichai\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Google"));
    }
}
