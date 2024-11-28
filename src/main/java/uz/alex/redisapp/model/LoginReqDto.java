package uz.alex.redisapp.model;

import lombok.Data;

@Data
public class LoginReqDto {
    private String username;
    private String password;
}
