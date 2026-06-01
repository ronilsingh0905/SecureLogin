package com.example.ronildevelops.SecureLogin.Service;

import com.example.ronildevelops.SecureLogin.DTO.TaskRequest;
import com.example.ronildevelops.SecureLogin.DTO.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getMyTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);
}