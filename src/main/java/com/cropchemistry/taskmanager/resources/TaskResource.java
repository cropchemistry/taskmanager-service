package com.cropchemistry.taskmanager.resources;

import com.cropchemistry.taskmanager.dto.TaskDTO;
import com.cropchemistry.taskmanager.model.Task;
import com.cropchemistry.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Component
public class TaskResource {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TaskDTO createTask(Task inputTask) {
        // TODO: Input validation
        return taskService.createTask(inputTask);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDTO> getAllTasks() {
        // TODO: Input validation
        return taskService.getAllTasks();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public TaskDTO getTaskById(@PathParam("id") Long taskId) {
        // TODO: Input validation
        return taskService.getTaskById(taskId);
    }

}