package com.webapp.CV.service.impl;

import com.webapp.CV.domain.Task;
import com.webapp.CV.domain.User;
import com.webapp.CV.repository.TaskRepository;
import com.webapp.CV.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(n -> tasks.add((Task) n));
        return tasks;
    }

    @Override
    public List<Task> findByStatus(String status) {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(x->{
           Task n= (Task) x;
            if(n.getStatus().equals(status)) {
               tasks.add(n);
           }
        });
        return tasks;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task findByName(String name) {
        return taskRepository.findByName(name);
    }
    public void saveTask(Task task){
        taskRepository.save(task);
    }
    public void deleteAll(){
        taskRepository.deleteAll();
    }

    @Override
    public List<Task> findAllByAssigneeAndStatus(User assignee, String status) {
        return taskRepository.findAllByAssigneeAndStatus(assignee,status);
    }
}
