package com.example.ronildevelops.SecureLogin.DTO;

import com.example.ronildevelops.SecureLogin.Entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private TaskStatus status;

}
