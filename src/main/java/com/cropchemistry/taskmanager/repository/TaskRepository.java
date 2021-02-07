package com.cropchemistry.taskmanager.repository;

import com.cropchemistry.taskmanager.dto.TaskDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskDTO, Long> {
}
