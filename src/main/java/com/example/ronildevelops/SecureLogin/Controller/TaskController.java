package com.example.ronildevelops.SecureLogin.Controller;

import com.example.ronildevelops.SecureLogin.DTO.TaskRequest;
import com.example.ronildevelops.SecureLogin.DTO.TaskResponse;
import com.example.ronildevelops.SecureLogin.Service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public TaskResponse createTask(
            @Valid @RequestBody TaskRequest request) {

        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponse> getTasks() {

        return taskService.getMyTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id) {

        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequest request) {

        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
    }
}