package com.springBootProj.jdbc.dao;

import com.springBootProj.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
    }

    // select * from Person where id =
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    //Select * from person where name =
    public List<Person> findByName(String name) {
        return jdbcTemplate.query("select * from person where name = ?", new Object[]{name},new BeanPropertyRowMapper<Person>(Person.class));
    }

    //delete a person where id=
    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?", new Object[]{id});
    }

    //insert into person (id, name, location, birth_date) values = ?, ? ,? ,?
    public int insertPerson(Person person){
        return  jdbcTemplate.update("insert into person (id, name, location, birth_date)"
                +" values (?,?,?,?)", new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
    }

    //update person
    public int updatePerson(Person person){
        return jdbcTemplate.update("update person set name = ?, location= ?, birth_date=? where id= ? ",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
    }
}
