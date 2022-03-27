package com.springBootProj.jdbc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;


@Entity
@NamedQuery(name="find_all_person", query = "select p from Person p")
@NamedQuery(name = "find_by_name", query = "select p from Person p where p.name=:nameOfPerson")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String location;
    private String name;
    private Date birthDate;

    public Person() {
    }

    public Person(int id, String location, String name, Date birthDate) {
        super();
        this.id = id;
        this.location = location;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String location, String name, Date birthDate) {
        super();
        this.id = id;
        this.location = location;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

}
