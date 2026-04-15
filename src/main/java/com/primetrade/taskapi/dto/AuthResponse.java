package com.primetrade.taskapi.dto;
import lombok.*;

@Data @AllArgsConstructor
public class AuthResponse {
    private String token;
    private String role;
    private String username;
}