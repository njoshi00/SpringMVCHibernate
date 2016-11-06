package com.springhibernate.tests;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDAOTest {

    @Autowired
    @Qualifier("personDAO")
    private PersonDAO dao;

    @Before
    public void addPersons() {
        try {
            Person person = new Person();
            person.setName("Jasmin");
            person.setCountry("India");
            dao.addPerson(person);

            Person person2 = new Person();
            person2.setName("Richard");
            person2.setCountry("US");
            dao.addPerson(person2);

        } catch (Exception e) {
            Assert.fail("Error occurred ");
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testAddPersons() {
        try {
            Person person = new Person();
            person.setName("Sachin");
            person.setCountry("India");
            dao.addPerson(person);

        } catch (Exception e) {
            Assert.fail("Error occurred testAddPersons");
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testListPersons() {
        try {
            List<Person> pList = dao.listPersons();
            Assert.assertNotNull(pList);
            Assert.assertTrue(pList.size() > 0);
            for (Person p : pList) {
                System.out.println(" -------------------- " + p.getId() + " " + p.getName() + " " + p.getCountry());
            }
        } catch (Exception e) {
            Assert.fail("Error occurred testListPersons");
        }
    }
}
