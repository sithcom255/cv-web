package com.webapp.CV.repository;

import com.webapp.CV.domain.Task;
import com.webapp.CV.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByName(String name);

    List<Task> findAllByAssigneeAndStatus(User assignee,String status);
}
