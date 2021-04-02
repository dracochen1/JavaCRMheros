package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Civil;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest extends TestBase {

    @Test
    public void TestCivilLogIn() throws Exception {
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
                get("/auth/login/" + c.getMail())

        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mail").value(c.getMail()));
    }
}
