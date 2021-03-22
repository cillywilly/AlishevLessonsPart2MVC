package ru.illarionov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.illarionov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom",11,"tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Alex",14,"alex@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Sergey",21,"sergey@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Jerry",61,"jerry@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBoUpdated = show(id);
        personToBoUpdated.setName(updatePerson.getName());
        personToBoUpdated.setAge(updatePerson.getAge());
        personToBoUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
