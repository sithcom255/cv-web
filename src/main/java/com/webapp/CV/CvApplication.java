package com.webapp.CV;

import com.webapp.CV.domain.Task;
import com.webapp.CV.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CvApplication {

	@Autowired
	TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Task task1 = new Task();
		task1.setName("curak2");
		Task task2 = new Task();
		task2.setName("konsky kokot2");
		taskRepository.save(task1);
		taskRepository.save(task2);
	}
}
