package com.webapp.CV.repository;

import com.webapp.CV.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
