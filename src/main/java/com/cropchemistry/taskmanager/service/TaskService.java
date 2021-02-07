package com.cropchemistry.taskmanager.service;

import com.cropchemistry.taskmanager.dto.TaskDTO;
import com.cropchemistry.taskmanager.model.Task;
import com.cropchemistry.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = false)
    public TaskDTO createTask(Task inputTask) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(inputTask.getTitle());
        taskDTO.setDescription(inputTask.getDescription());
        return taskRepository.save(taskDTO);
    }

    public List<TaskDTO> getAllTasks() {
        return StreamSupport
                .stream(taskRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long taskId) {
        Optional<TaskDTO> optionalTaskDTO = taskRepository.findById(taskId);
        return optionalTaskDTO.isPresent() ? optionalTaskDTO.get() : null;
    }
}
