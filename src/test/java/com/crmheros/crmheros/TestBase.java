package com.crmheros.crmheros;

import com.crmheros.crmheros.repositories.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
@AutoConfigureMockMvc
public abstract class TestBase {
    @Autowired
    protected CivilRepository civilRepository;

    @Autowired
    protected OrganizationRepository organizationRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected CriseRepository criseRepository;

    @Autowired
    protected SatisfactionRepository satisfactionRepository;

    @Autowired
    protected MockMvc mockMvc;
}
