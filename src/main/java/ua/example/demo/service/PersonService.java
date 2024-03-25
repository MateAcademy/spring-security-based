package ua.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.example.demo.models.Person;
import ua.example.demo.repositories.PersonRepositories;

import javax.transaction.Transactional;

@Service
public class PersonService {

    private final PersonRepositories personRepositories;

    @Autowired
    public PersonService(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    @Transactional
    public void add(Person person) {
        personRepositories.save(person);
    }
}
