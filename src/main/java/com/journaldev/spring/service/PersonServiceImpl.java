package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(Person p) {
        try {
            this.personDAO.addPerson(p);
        } catch (Exception e) {
        }

    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        try {
            this.personDAO.updatePerson(p);
        } catch (Exception e) {
        }

    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        try {
            return this.personDAO.listPersons();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        try {
            return this.personDAO.getPersonById(id);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    @Transactional
    public void removePerson(int id) {
        try {
            this.personDAO.removePerson(id);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Person> listPersons(String s, String userSession) {
        return null;
    }

}
