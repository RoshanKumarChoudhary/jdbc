package com.springBootProj.jdbc;

import com.springBootProj.jdbc.dao.PersonJdbcDao;
import com.springBootProj.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person call -> {}", personJdbcDao.findAll());

		logger.info("Person Call by id --> {}", personJdbcDao.findById(1002));

		logger.info("Person By name roshan --> {}", personJdbcDao.findByName("ROSHAN"));

		logger.info("Delete person by id --> {}", personJdbcDao.deleteById(1003));

		logger.info("Insert person --> {}", personJdbcDao.insertPerson(new Person(1004, "Kk", "Quick" ,new Date())));

		logger.info("Update person --> {}", personJdbcDao.updatePerson(new Person(1004,"NA","Quick", new Date())));
	}
}
