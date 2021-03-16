package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Organization;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrganizationsControllerTest extends TestBase {
    private static SimpleDateFormat formatingdate = new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void TestOrganizationsCreation() throws Exception {
        formatingdate.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.mockMvc.perform(
                post("/organizations/")
                        .content("{ \"name\": \"Google\", \"headOffice\": \"California\", \"headOfficer\": \"Sundar Pichai\", \"member\" : \"Andrew Pavlov\", \"comment\" : \"May be interested in a 24H care service\", \"createdAt\" : \"1996-11-18\", \"updatedAt\" : \"1996-11-18\", \"numberOfIncidentsDeclared\": \"2\", \"numberOfAccidentsSuffered\" : \"6\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Google"))
                .andExpect(jsonPath("$.headOffice").value("California"))
                .andExpect(jsonPath("$.headOfficer").value("Sundar Pichai"))
                .andExpect(jsonPath("$.member").value("Andrew Pavlov"))
                .andExpect(jsonPath("$.comment").value("May be interested in a 24H care service"))
                .andExpect(jsonPath("$.createdAt").value(formatingdate.parse("1996-11-18")))
                .andExpect(jsonPath("$.updatedAt").value(formatingdate.parse("1996-11-18")))
                .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("2"))
                .andExpect(jsonPath("$.numberOfAccidentsSuffered").value("6"));
    }

    @Test
    public void TestOrganizationGet() throws Exception {
        Date d = formatingdate.parse("1996-11-18");
        Organization o = new Organization();
        o.setName("Google");
        o.setHeadOffice("California");
        o.setHeadOfficer("Sundar Pichai");
        o.setComment("May be interested in a 24H care service");
        o.setCreatedAt(d);
        o.setUpdatedAt(d);
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
                .andExpect(jsonPath("$.createdAt").value(formatingdate.parse("1996-11-18")))
                .andExpect(jsonPath("$.updatedAt").value(formatingdate.parse("1996-11-18")))
                .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("2"))
                .andExpect(jsonPath("$.numberOfAccidentsSuffered").value("6"))
                .andExpect(jsonPath("$.id").value(o.getId().toString()));
    }

    @Test
    public void TestOrganizationUpdate() throws Exception {
        Date d = formatingdate.parse("1996-11-18");
        formatingdate.setTimeZone(TimeZone.getTimeZone("UTC"));
        Organization o = new Organization();
        o.setName("Google");
        o.setHeadOffice("California");
        o.setHeadOfficer("Sundar Pichai");
        o.setComment("May be interested in a 24H care service");
        o.setCreatedAt(d);
        o.setUpdatedAt(d);
        o.setNumberOfIncidentsDeclared(2);
        o.setNumberOfAccidentsSuffered(6);
        organizationRepository.save(o);

        this.mockMvc.perform(
                post("/organizations/")
                        .content("{ \"name\": \"BlaBlaCar\", \"headOffice\": \"Paris\", \"headOfficer\": \"Frédéric Mazzella\", \"member\" : \"Nicolas Barba\", \"comment\" : \"Not interested in a 24H care service\", \"createdAt\" : \"1996-11-18\", \"updatedAt\" : \"1996-11-18\", \"numberOfIncidentsDeclared\": \"4\", \"numberOfAccidentsSuffered\": \"12\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("BlaBlaCar"))
                .andExpect(jsonPath("$.headOffice").value("Paris"))
                .andExpect(jsonPath("$.headOfficer").value("Frédéric Mazzella"))
                .andExpect(jsonPath("$.comment").value("Not interested in a 24H care service"))
                .andExpect(jsonPath("$.createdAt").value(formatingdate.parse("1996-11-18")))
                .andExpect(jsonPath("$.updatedAt").value(formatingdate.parse("1996-11-18")))
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
        o.setCreatedAt(new Date());
        o.setUpdatedAt(new Date());
        o.setNumberOfIncidentsDeclared(2);
        o.setNumberOfAccidentsSuffered(6);
        organizationRepository.save(o);

        this.mockMvc.perform(
                delete("/organizations/" + o.getId().toString())
        )
                .andExpect(status().isOk());
    }

}
