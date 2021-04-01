package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Litigation;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LitigationControllerTest extends TestBase {
    @Test
    public void TestLitigeCreation() throws Exception{
        this.mockMvc.perform(
                post("/litiges/")
                    .content("{ \"object\": \"Litige mission de new york du 11 mars 2021\", \"type\": \"destruction de bien materiel\", \"relatedPersons\": \"Hulk, Iron-man\", \"mission\" : \"Mission du 11 mars\", \"cost\":1000000,\"photo\":\"...\" }")
                    .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.object").value("Litige mission de new york du 11 mars 2021"))
                .andExpect(jsonPath("$.type").value("destruction de bien materiel"))
                .andExpect(jsonPath("$.relatedPersons").value("Hulk, Iron-man"))
                .andExpect(jsonPath("$.mission").value("Mission du 11 mars"))
                .andExpect(jsonPath("$.cost").value(1000000))
                .andExpect(jsonPath("$.photo").value("..."));
    }
    @Test
    public void TestLitigeGet() throws Exception{
        Litigation l = new Litigation();
        l.setObject("Litige mission de new york du 11 mars 2021");
        l.setType("destruction de bien materiel");
        l.setRelatedPersons("Hulk, Iron-man");
        l.setMission("Mission du 11 mars");
        l.setCost(1000000);
        l.setPhoto("...");
        litigationRepository.save(l);

        this.mockMvc.perform(
                get("/litiges/" + l.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.object").value("Litige mission de new york du 11 mars 2021"))
                .andExpect(jsonPath("$.type").value("destruction de bien materiel"))
                .andExpect(jsonPath("$.relatedPersons").value("Hulk, Iron-man"))
                .andExpect(jsonPath("$.mission").value("Mission du 11 mars"))
                .andExpect(jsonPath("$.cost").value(1000000))
                .andExpect(jsonPath("$.photo").value("..."));
    }
    @Test
    public void TestLitigeUpdate() throws Exception{
        Litigation l = new Litigation();
        l.setObject("Litige mission de new york du 11 mars 2021");
        l.setType("destruction de bien materiel");
        l.setRelatedPersons("Hulk, Iron-man");
        l.setMission("Mission du 11 mars");
        l.setCost(1000000);
        l.setPhoto("...");
        litigationRepository.save(l);

        this.mockMvc.perform(
                patch("/litiges/" + l.getId().toString())
                        .content("{ \"object\": \"Litige mission los angeles du 10 decembre 2019\", \"type\": \"destruction de bien materiel\", \"relatedPersons\": \"Spider-man\", \"mission\" : \"Mission du 10 decembre 2019\", \"cost\":10000,\"photo\":\"...\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.object").value("Litige mission los angeles du 10 decembre 2019"))
                .andExpect(jsonPath("$.type").value("destruction de bien materiel"))
                .andExpect(jsonPath("$.relatedPersons").value("Spider-man"))
                .andExpect(jsonPath("$.mission").value("Mission du 10 decembre 2019"))
                .andExpect(jsonPath("$.cost").value(10000))
                .andExpect(jsonPath("$.photo").value("..."));
    }
    @Test
    public void TestLitigeDelete() throws Exception{
        Litigation l = new Litigation();
        l.setObject("Litige mission de new york du 11 mars 2021");
        l.setType("destruction de bien materiel");
        l.setRelatedPersons("Hulk, Iron-man");
        l.setMission("Mission du 11 mars");
        l.setCost(1000000);
        l.setPhoto("...");
        litigationRepository.save(l);
        this.mockMvc.perform(
                delete("/litiges/" + l.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
