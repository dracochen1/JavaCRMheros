package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Organization;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrganizationsControllerTest extends TestBase {
    @Test
    public void TestOrganizationsCreation() throws Exception {
        this.mockMvc.perform(
                post("/organizations/")
                        .content("{ \"name\": \"Google\", \"headOffice\": \"California\", \"headOfficer\": \"Sundar Pichai\", \"member\" : \"Andrew Pavlov\", \"comment\" : \"May be interested in a 24H care service\", \"createdAt\" : \"04/01/2021\", \"updatedAt\" : \"01/03/2021\", \"numberOfIncidentsDeclared\": \"2\", \"numberOfAccidentsSuffered\" : \"6\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Google"))
                .andExpect(jsonPath("$.headOffice").value("California"))
                .andExpect(jsonPath("$.headOfficer").value("Sundar Pichai"))
                .andExpect(jsonPath("$.member").value("Andrew Pavlov"))
                .andExpect(jsonPath("$.comment").value("May be interested in a 24H care service"))
                .andExpect(jsonPath("$.createdAt").value("04/01/2021"))
                .andExpect(jsonPath("$.updatedAt").value("01/03/2021"))
                .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("2"))
                .andExpect(jsonPath("$.numberOfAccidentsSuffered").value("6"));
    }

    @Test
    public void TestOrganizationGet() throws Exception {
        Organization o = new Organization();
        o.setName("Google");
        o.setHeadOffice("California");
        o.setHeadOfficer("Sundar Pichai");
        o.setComment("May be interested in a 24H care service");
        o.setCreatedAt("04/01/2021");
        o.setUpdatedAt("01/03/2021");
        o.setNumberOfIncidentsDeclared(2);
        o.setNumberOfAccidentsSuffered(6);
        organizationRepository.save(o);

        this.mockMvc.perform(
                get("/organizations/" + o.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Google"))
                .andExpect(jsonPath("$.headOffice").value("California"))
                .andExpect(jsonPath("$.headOfficer").value("Sundar Pichai"))
                .andExpect(jsonPath("$.comment").value("May be interested in a 24H care service"))
                .andExpect(jsonPath("$.createdAt").value("04/01/2021"))
                .andExpect(jsonPath("$.updatedAt").value("01/03/2021"))
                .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("2"))
                .andExpect(jsonPath("$.numberOfAccidentsSuffered").value("6"))
                .andExpect(jsonPath("$.id").value(o.getId().toString()));
    }

    @Test
    public void TestOrganizationUpdate() throws Exception {
        Organization o = new Organization();
        o.setName("Google");
        o.setHeadOffice("California");
        o.setHeadOfficer("Sundar Pichai");
        o.setComment("May be interested in a 24H care service");
        o.setCreatedAt("04/01/2021");
        o.setUpdatedAt("01/03/2021");
        o.setNumberOfIncidentsDeclared(2);
        o.setNumberOfAccidentsSuffered(6);
        organizationRepository.save(o);

        this.mockMvc.perform(
                post("/organizations/")
                        .content("{ \"name\": \"BlaBlaCar\", \"headOffice\": \"Paris\", \"headOfficer\": \"Frédéric Mazzella\", \"member\" : \"Nicolas Barba\", \"comment\" : \"Not interested in a 24H care service\", \"createdAt\" : \"06/01/2021\", \"updatedAt\" : \"06/03/2021\", \"numberOfIncidentsDeclared\": \"4\", \"numberOfAccidentsSuffered\": \"12\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("BlaBlaCar"))
                .andExpect(jsonPath("$.headOffice").value("Paris"))
                .andExpect(jsonPath("$.headOfficer").value("Frédéric Mazzella"))
                .andExpect(jsonPath("$.comment").value("Not interested in a 24H care service"))
                .andExpect(jsonPath("$.createdAt").value("06/01/2021"))
                .andExpect(jsonPath("$.updatedAt").value("06/03/2021"))
                .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("4"))
                .andExpect(jsonPath("$.numberOfAccidentsSuffered").value("12"));
    }

    @Test
    public void TestOrganizationDelete() throws Exception {
        Organization o = new Organization();
        o.setName("Google");
        o.setHeadOffice("California");
        o.setHeadOfficer("Sundar Pichai");
        o.setComment("May be interested in a 24H care service");
        o.setCreatedAt("04/01/2021");
        o.setUpdatedAt("01/03/2021");
        o.setNumberOfIncidentsDeclared(2);
        o.setNumberOfAccidentsSuffered(6);
        organizationRepository.save(o);

        this.mockMvc.perform(
                delete("/organizations/" + o.getId().toString())
        )
                .andExpect(status().isOk());
    }

}
