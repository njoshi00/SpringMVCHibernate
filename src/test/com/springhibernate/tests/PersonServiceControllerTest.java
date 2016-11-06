package com.springhibernate.tests;

import com.journaldev.spring.PersonController;
import com.journaldev.spring.service.PersonService;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import java.lang.AssertionError;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
 * Created by M1017606 on 10/19/2016.
 */
@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private PersonService personService;

    PersonController controller = new PersonController();

    @org.junit.Before
    public  void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public  void test(){
        try {
            mockMvc.perform(get("/admin/userManagement")).andExpect(status().isFound())
                    .andExpect(view().name("redirect:/login.html"));
        } catch (Exception e) {
            e.printStackTrace();
            Asser
        }
    }

}
