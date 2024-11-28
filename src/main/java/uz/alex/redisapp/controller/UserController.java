package uz.alex.redisapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.alex.redisapp.model.UserModel;
import uz.alex.redisapp.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/list")
    public List<UserModel> getUsers() {
        return service.getAllUsers();
    }
}
