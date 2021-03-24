package ru.illarionov.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.illarionov.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static int PEOPLE_COUNT;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query(
                "select * from person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person values (1,?,?,?)",
                person.getName(),person.getAge(),person.getEmail());
    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.update("update person set name =?,age=?, email=?  where id=?",
                updatePerson.getName(), updatePerson.getAge(), updatePerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }
}
