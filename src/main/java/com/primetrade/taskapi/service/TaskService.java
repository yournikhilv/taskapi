package com.primetrade.taskapi.service;

import com.primetrade.taskapi.dto.TaskRequest;
import com.primetrade.taskapi.entity.*;
import com.primetrade.taskapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Task createTask(TaskRequest req, String email) {
        User user = getUser(email);
        Task task = Task.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .status(req.getStatus())
                .user(user).build();
        return taskRepository.save(task);
    }

    public List<Task> getMyTasks(String email) {
        return taskRepository.findByUserId(getUser(email).getId());
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, TaskRequest req, String email) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (!task.getUser().getEmail().equals(email))
            throw new RuntimeException("Unauthorized");
        task.setTitle(req.getTitle());
        task.setDescription(req.getDescription());
        task.setStatus(req.getStatus());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id, String email) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (!task.getUser().getEmail().equals(email))
            throw new RuntimeException("Unauthorized");
        taskRepository.delete(task);
    }
}