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
                    .content("{ \"firstName\": \"Naka\", \"lastName\": \"TheShiba\", \"civility\": \"Francais\", \"address\": \"10 rue de la joie, Paris\", \"mail\": \"naka@nuag.fr\", \"phone\": \"1865457689\", \"dateOfBirth\": \"06/07/2010\", \"dateAdded\": \"06/01/2020\", \"numberOfIncidentsDeclared\": \"100\" }")
                    .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Naka"))
            .andExpect(jsonPath("$.lastName").value("TheShiba"))
            .andExpect(jsonPath("$.civility").value("Francais"))
            .andExpect(jsonPath("$.address").value("10 rue de la joie, Paris"))
            .andExpect(jsonPath("$.mail").value("naka@nuag.fr"))
            .andExpect(jsonPath("$.phone").value("1865457689"))
            .andExpect(jsonPath("$.dateOfBirth").value("06/07/2010"))
            .andExpect(jsonPath("$.dateAdded").value("06/01/2020"))
            .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("100"));
    }

    @Test
    public void TestUserGet() throws Exception
    {
        Civil c = new Civil();
        c.setFirstName("Naka");
        c.setLastName("TheShiba");
        c.setCivility("Japonais");
        c.setAddress("5 rue du soleil, Tokyo");
        c.setMail("nakamoto@bitcoin.jp");
        c.setPhone(672345677);
        c.setDateOfBirth("12/05/2017");
        c.setComment("yahhouuuuuu le chien");
        c.setDateAdded("11/08/2020");
        c.setNumberOfIncidentsDeclared(3);
        civilRepository.save(c);

        this.mockMvc.perform(
                get("/civils/" + c.getId().toString())
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Naka"))
            .andExpect(jsonPath("$.lastName").value("TheShiba"))
            .andExpect(jsonPath("$.civility").value("Japonais"))
            .andExpect(jsonPath("$.address").value("5 rue du soleil, Tokyo"))
            .andExpect(jsonPath("$.mail").value("nakamoto@bitcoin.jp"))
            .andExpect(jsonPath("$.phone").value("672345677"))
            .andExpect(jsonPath("$.dateOfBirth").value("12/05/2017"))
            .andExpect(jsonPath("$.comment").value("yahhouuuuuu le chien"))
            .andExpect(jsonPath("$.dateAdded").value("11/08/2020"))
            .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("3"))
            .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestUserUpdate() throws Exception
    {
        Civil c = new Civil();
        c.setFirstName("Naka");
        c.setLastName("TheShiba");
        c.setCivility("Japonais");
        c.setAddress("5 rue du soleil, Tokyo");
        c.setMail("nakamoto@bitcoin.jp");
        c.setPhone(672345677);
        c.setDateOfBirth("12/05/2017");
        c.setDateAdded("11/08/2020");
        c.setNumberOfIncidentsDeclared(3);
        civilRepository.save(c);

        this.mockMvc.perform(
                patch("/civils/" + c.getId().toString())
                        .content("{ \"firstName\": \"BigNaka\", \"lastName\": \"TheFatShiba\", \"civility\": \"Coréen\", \"address\": \"10 rue de la joie, Séoul\", \"mail\": \"naka@nuag.fr\", \"phone\": \"1865457689\", \"dateOfBirth\": \"06/07/2010\", \"dateAdded\": \"06/01/2020\", \"numberOfIncidentsDeclared\": \"100\", \"password\": \"123456\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("BigNaka"))
            .andExpect(jsonPath("$.lastName").value("TheFatShiba"))
            .andExpect(jsonPath("$.civility").value("Coréen"))
            .andExpect(jsonPath("$.address").value("10 rue de la joie, Séoul"))
            .andExpect(jsonPath("$.mail").value("naka@nuag.fr"))
            .andExpect(jsonPath("$.phone").value("1865457689"))
            .andExpect(jsonPath("$.dateOfBirth").value("06/07/2010"))
            .andExpect(jsonPath("$.dateAdded").value("06/01/2020"))
            .andExpect(jsonPath("$.password").value("123456"))
            .andExpect(jsonPath("$.numberOfIncidentsDeclared").value("100"))
            .andExpect(jsonPath("$.id").value(c.getId().toString()));
    }

    @Test
    public void TestUserDelete() throws Exception
    {
        Civil c = new Civil();
        c.setFirstName("Naka");
        c.setLastName("TheShiba");
        c.setCivility("Japonais");
        c.setAddress("5 rue du soleil, Tokyo");
        c.setMail("nakamoto@bitcoin.jp");
        c.setPhone(672345677);
        c.setDateOfBirth("12/05/2017");
        c.setComment("yahhouuuuuu le chien");
        c.setDateAdded("11/08/2020");
        c.setNumberOfIncidentsDeclared(3);
        civilRepository.save(c);

        this.mockMvc.perform(
                delete("/civils/" + c.getId().toString())
        )
            .andExpect(status().isOk());
    }
}
