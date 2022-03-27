package com.springBootProj.jdbc;

import com.springBootProj.jdbc.dao.PersonJdbcDao;
import com.springBootProj.jdbc.dao.jpa.PersonJpaDao;
import com.springBootProj.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringJPAApplication implements CommandLineRunner {

	@Autowired
	PersonJpaDao personJpaDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Person Call by id --> {}", personJpaDao.findById(1002));

		logger.info("Insert person --> {}", personJpaDao.insertPerson(new Person( "Kk", "Quick" ,new Date())));

		logger.info("Update person --> {}", personJpaDao.updatePerson(new Person(1003,"NA","Quick", new Date())));

		personJpaDao.deleteById(1003);

		logger.info("Person call -> {}", personJpaDao.findAll());


		logger.info("Person By name roshan --> {}", personJpaDao.findByName("ROSHAN"));


	}
}
