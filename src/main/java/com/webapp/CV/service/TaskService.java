package com.webapp.CV.service;

import com.webapp.CV.domain.Task;
import com.webapp.CV.domain.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {
     List<Task> getAll ();

     List<Task> findByStatus(String status);

     Optional<Task> findById(Long id);

     Task findByName(String name);

     void saveTask(Task task);
     void deleteAll();

     List<Task> findAllByAssigneeAndStatus(User assignee, String status);
}
