package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Satisfaction;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SatisfactionControllerTest extends TestBase {
    @Test
    public void TestSatisfactionCreation() throws Exception {
        this.mockMvc.perform(
                post("/satisfactions/")
                        .content("{ \"phone\": \"687654321\", \"mail\": \"test@examle.com\", \"score\": \"3\", \"comment\": \"éternelle gratitude\", \"source\": \"envoi texto\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone").value("687654321"))
                .andExpect(jsonPath("$.mail").value("test@examle.com"))
                .andExpect(jsonPath("$.score").value("3"))
                .andExpect(jsonPath("$.comment").value("éternelle gratitude"))
                .andExpect(jsonPath("$.source").value("envoi texto"));
    }

    @Test
    public void TestSatisfactionGet() throws Exception {
        Satisfaction s = new Satisfaction();
        s.setPhone(687654321);
        s.setMail("test@examle.com");
        s.setScore(3);
        s.setComment("éternelle gratitude");
        s.setSource("envoi texto");
        satisfactionRepository.save(s);

        this.mockMvc.perform(
                get("/satisfactions/" + s.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone").value("687654321"))
                .andExpect(jsonPath("$.mail").value("test@examle.com"))
                .andExpect(jsonPath("$.score").value("3"))
                .andExpect(jsonPath("$.comment").value("éternelle gratitude"))
                .andExpect(jsonPath("$.source").value("envoi texto"))
                .andExpect(jsonPath("$.id").value(s.getId().toString()));
    }

    @Test
    public void TestSatisfactionUpdate() throws Exception {
        Satisfaction s = new Satisfaction();
        s.setPhone(687654321);
        s.setMail("test@examle.com");
        s.setScore(3);
        s.setComment("éternelle gratitude");
        s.setSource("envoi texto");
        satisfactionRepository.save(s);

        this.mockMvc.perform(
                patch("/satisfactions/" + s.getId().toString())
                        .content("{ \"phone\": \"12345567\", \"mail\": \"test1@examle.com\", \"score\": \"4\", \"comment\": \"trop brut\", \"source\": \"témoignage journal\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone").value("12345567"))
                .andExpect(jsonPath("$.mail").value("test1@examle.com"))
                .andExpect(jsonPath("$.score").value("4"))
                .andExpect(jsonPath("$.comment").value("trop brut"))
                .andExpect(jsonPath("$.source").value("témoignage journal"))
                .andExpect(jsonPath("$.id").value(s.getId().toString()));
    }

    @Test
    public void TestSatisfactionDelete() throws Exception {
        Satisfaction s = new Satisfaction();
        s.setPhone(687654321);
        s.setMail("test@examle.com");
        s.setScore(3);
        s.setComment("éternelle gratitude");
        s.setSource("envoi texto");
        satisfactionRepository.save(s);

        this.mockMvc.perform(
                delete("/satisfactions/" + s.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
