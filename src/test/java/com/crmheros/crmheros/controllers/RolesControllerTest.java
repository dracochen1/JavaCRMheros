package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Role;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RolesControllerTest extends TestBase {
    @Test
    public void TestRoleCreation() throws Exception {
        this.mockMvc.perform(
                post("/roles/")
                        .content("{ \"name\": \"Employee\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Employee"));
    }

    @Test
    public void TestRoleGet() throws Exception {
        Role c = new Role();
        c.setName("Employee");

        roleRepository.save(c);

        this.mockMvc.perform(
                get("/roles/" + c.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Employee"))
                .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }
    @Test
    public void TestRoleUpdate() throws Exception
    {
        Role c = new Role();
        c.setName("Employee");

        roleRepository.save(c);

        this.mockMvc.perform(
                patch("/roles/" + c.getId().toString())
                        .content("{ \"name\": \"Super master\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Super master"))
                .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestRoleDelete() throws Exception
    {
        Role c = new Role();
        c.setName("Employee");

        roleRepository.save(c);

        this.mockMvc.perform(
                delete("/roles/" + c.getId().toString())
        )
                .andExpect(status().isOk());
    }
}

