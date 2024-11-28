package uz.alex.redisapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.alex.redisapp.config.component.JwtTokenProvider;
import uz.alex.redisapp.entity.UserEntity;
import uz.alex.redisapp.model.LoginReqDto;
import uz.alex.redisapp.model.RegisterResponse;
import uz.alex.redisapp.model.SignUpRequest;
import uz.alex.redisapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String login(LoginReqDto loginReqDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginReqDto.getUsername(),
                loginReqDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    return jwtTokenProvider.generateToken(authentication);
    }

    public RegisterResponse register(SignUpRequest request) {
        UserEntity entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(entity);

        RegisterResponse response = new RegisterResponse();
        response.setUserId(entity.getId());
        response.setUsername(request.getUsername());
        return response;
    }
}

