package com.example.ronildevelops.SecureLogin.Service.impl;

import com.example.ronildevelops.SecureLogin.DTO.TaskRequest;
import com.example.ronildevelops.SecureLogin.DTO.TaskResponse;
import com.example.ronildevelops.SecureLogin.Entity.TaskEntity;
import com.example.ronildevelops.SecureLogin.Entity.TaskStatus;
import com.example.ronildevelops.SecureLogin.Entity.UserEntity;
import com.example.ronildevelops.SecureLogin.Repository.TaskEntityRepository;
import com.example.ronildevelops.SecureLogin.Repository.UserEntityRepository;
import com.example.ronildevelops.SecureLogin.Service.TaskService;
import com.example.ronildevelops.SecureLogin.exception.AccessDeniedException;
import com.example.ronildevelops.SecureLogin.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskEntityRepository taskRepository;
    private final UserEntityRepository userRepository;

    private UserEntity getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public TaskResponse createTask(TaskRequest request) {

        UserEntity user = getCurrentUser();

        TaskEntity task = TaskEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(
                        request.getStatus() == null
                                ? TaskStatus.PENDING
                                : request.getStatus()
                )
                .createdBy(user)
                .build();

        task = taskRepository.save(task);

        return mapToResponse(task);
    }

    @Override
    public List<TaskResponse> getMyTasks() {

        UserEntity user = getCurrentUser();

        return taskRepository.findByCreatedBy(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id) {

        UserEntity user = getCurrentUser();

        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        if (!task.getCreatedBy().getId().equals(user.getId())) {
            throw new AccessDeniedException("You are not allowed to access this task");
        }

        return mapToResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {

        UserEntity user = getCurrentUser();

        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        if (!task.getCreatedBy().getId().equals(user.getId())) {
            throw new AccessDeniedException("You are not allowed to update this task");
        }

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }

        task = taskRepository.save(task);

        return mapToResponse(task);
    }

    @Override
    public void deleteTask(Long id) {

        UserEntity user = getCurrentUser();

        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        if (!task.getCreatedBy().getId().equals(user.getId())) {
            throw new AccessDeniedException("You are not allowed to delete this task");
        }

        taskRepository.delete(task);
    }

    private TaskResponse mapToResponse(TaskEntity task) {

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .createdBy(task.getCreatedBy().getEmail())
                .build();
    }
}