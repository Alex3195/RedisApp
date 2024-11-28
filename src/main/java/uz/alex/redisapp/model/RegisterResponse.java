package uz.alex.redisapp.model;

import lombok.Data;

@Data
public class RegisterResponse {
    private Long userId;
    private String username;
}
