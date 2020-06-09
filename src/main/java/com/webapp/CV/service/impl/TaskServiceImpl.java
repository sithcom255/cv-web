package com.webapp.CV.service.impl;

import com.webapp.CV.domain.Task;
import com.webapp.CV.repository.TaskRepository;
import com.webapp.CV.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
