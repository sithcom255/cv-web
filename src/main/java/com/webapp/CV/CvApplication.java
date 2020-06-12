package com.webapp.CV;


import com.webapp.CV.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.webapp.CV")
@EnableTransactionManagement
@EntityScan(basePackages="com.webapp.CV")
public class CvApplication extends SpringBootServletInitializer {


	@Autowired
	TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}
}
