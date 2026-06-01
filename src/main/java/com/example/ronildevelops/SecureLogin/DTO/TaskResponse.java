package com.example.ronildevelops.SecureLogin.DTO;


import com.example.ronildevelops.SecureLogin.Entity.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponse {

    private Long id;

    private String title;

    private String description;

    private TaskStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;
}