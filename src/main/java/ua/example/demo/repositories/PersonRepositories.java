package ua.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.example.demo.models.Person;

import java.util.Optional;

@Repository
public interface PersonRepositories extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);

}
