package uz.alex.redisapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.alex.redisapp.model.LoginReqDto;
import uz.alex.redisapp.model.RegisterResponse;
import uz.alex.redisapp.model.SignUpRequest;
import uz.alex.redisapp.services.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginReqDto loginReqDto) {
        return service.login(loginReqDto);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody SignUpRequest signUpRequest) {
        return service.register(signUpRequest);
    }
}
