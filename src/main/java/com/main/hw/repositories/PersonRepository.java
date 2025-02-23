package com.main.hw.repositories;

import com.main.hw.models.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository
{
    private List<Person> persons;

    public List<Person> findAll()
    {
        return persons;
    }

    public Optional<Person> findById(int id)
    {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    @PostConstruct
    public void init()
    {
        persons = List.of(
            new Person(1, "Micky", "Colman", 56),
            new Person(2, "Donald", "Duncan", 45),
            new Person(3, "Raphael", "Pots", 34)
        );
    }
}
