package com.crmheros.crmheros.controllers;

import com.crmheros.crmheros.TestBase;
import com.crmheros.crmheros.models.Mission;
import com.crmheros.crmheros.models.Organization;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MissionControllerTest extends TestBase{
    @Test
    public void TestMissionsCreation() throws Exception {
        this.mockMvc.perform(
                post("/missions/")
                        .content("{ \"titre\": \"Sauver le monde\", \"nature\": \"Sauvetage\", \"road\": \"A l'angle de la maison blanche\", \"severitylevel\" : \"Haut\", \"emergencylevel\" : \"Prioritaire\", \"status\": \"En cour\", \"nombercivils\" : \"10\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titre").value("Sauver le monde"))
                .andExpect(jsonPath("$.nature").value("Sauvetage"))
                .andExpect(jsonPath("$.road").value("A l'angle de la maison blanche"))
                .andExpect(jsonPath("$.severitylevel").value("Haut"))
                .andExpect(jsonPath("$.emergencylevel").value("Prioritaire"))
                .andExpect(jsonPath("$.status").value("En cour"))
                .andExpect(jsonPath("$.nombercivils").value("10"));
    }

    @Test
    public void TestMissionGet() throws Exception {
        Mission o = new Mission();
        o.setTitre("Sauver le monde");
        o.setNature("Sauvetage");
        o.setRoad("Non loin de la maison blanche");
        o.setSeveritylevel("fort");
        o.setEmergencylevel("fort");
        o.setStatus("En cour");
        o.setNombercivils(1);

        missionRepository.save(o);

        this.mockMvc.perform(
                get("/missions/" + o.getId().toString())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titre").value("Sauver le monde"))
                .andExpect(jsonPath("$.nature").value("Sauvetage"))
                .andExpect(jsonPath("$.road").value("Non loin de la maison blanche"))
                .andExpect(jsonPath("$.severitylevel").value("fort"))
                .andExpect(jsonPath("$.emergencylevel").value("fort"))
                .andExpect(jsonPath("$.status").value("En cour"))
                .andExpect(jsonPath("$.nombercivils").value("1"))
                .andExpect(jsonPath("$.id").value(o.getId().toString()));
    }

    @Test
    public void TestMissionsUpdate() throws Exception {
        Mission o = new Mission();
        o.setTitre("Sauver le monde");
        o.setNature("Sauvetage");
        o.setRoad("Non loin de la maison blanche");
        o.setSeveritylevel("fort");
        o.setEmergencylevel("fort");
        o.setStatus("En cour");
        o.setNombercivils(1);

        missionRepository.save(o);

        this.mockMvc.perform(
                post("/missions/")
                        .content("{ \"titre\": \"Sauver le monde\", \"nature\": \"Sauvetage\", \"road\": \"A l'angle de la maison blanche\", \"severitylevel\" : \"Haut\", \"emergencylevel\" : \"Prioritaire\", \"status\": \"En cour\", \"nombercivils\" : \"10\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titre").value("Sauver le monde"))
                .andExpect(jsonPath("$.nature").value("Sauvetage"))
                .andExpect(jsonPath("$.road").value("A l'angle de la maison blanche"))
                .andExpect(jsonPath("$.severitylevel").value("Haut"))
                .andExpect(jsonPath("$.emergencylevel").value("Prioritaire"))
                .andExpect(jsonPath("$.status").value("En cour"))
                .andExpect(jsonPath("$.nombercivils").value("10"));
    }

    @Test
    public void TestMissionsDelete() throws Exception {
        Mission o = new Mission();
        o.setTitre("Sauver le monde");
        o.setNature("Sauvetage");
        o.setRoad("Non loin de la maison blanche");
        o.setSeveritylevel("fort");
        o.setEmergencylevel("fort");
        o.setStatus("En cour");
        o.setNombercivils(1);

        missionRepository.save(o);

        this.mockMvc.perform(
                delete("/missions/" + o.getId().toString())
        )
                .andExpect(status().isOk());
    }
}
