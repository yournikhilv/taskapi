package com.primetrade.taskapi.dto;
import com.primetrade.taskapi.entity.Task;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank private String title;
    private String description;
    private Task.Status status = Task.Status.TODO;
}