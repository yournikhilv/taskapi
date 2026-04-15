package com.primetrade.taskapi.controller;

import com.primetrade.taskapi.dto.TaskRequest;
import com.primetrade.taskapi.entity.Task;
import com.primetrade.taskapi.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(
            @Valid @RequestBody TaskRequest req, Authentication auth) {
        return ResponseEntity.ok(
                taskService.createTask(req, auth.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getMyTasks(Authentication auth) {
        return ResponseEntity.ok(taskService.getMyTasks(auth.getName()));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id,
                                       @Valid @RequestBody TaskRequest req, Authentication auth) {
        return ResponseEntity.ok(
                taskService.updateTask(id, req, auth.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id, Authentication auth) {
        taskService.deleteTask(id, auth.getName());
        return ResponseEntity.ok("Task deleted");
    }
}