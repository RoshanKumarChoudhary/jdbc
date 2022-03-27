package com.springBootProj.jdbc.dao.jpa;

import com.springBootProj.jdbc.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class PersonJpaDao {

    //connecting to db
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }
    public Person updatePerson(Person person) {
        return entityManager.merge(person);
    }
    public Person insertPerson(Person person) {
        return entityManager.merge(person);
    }
    public void deleteById(int id) {
        Person person = findById(id);
        if(person != null)
            entityManager.remove(person);
    }
    public List<Person> findAll(){
        TypedQuery<Person> namedQuery =entityManager.createNamedQuery("find_all_person",Person.class);
        return namedQuery.getResultList();
    }
    public List<Person> findByName(String name) {
        TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_by_name",Person.class).setParameter("nameOfPerson",name);
        return namedQuery.getResultList();
    }
}
