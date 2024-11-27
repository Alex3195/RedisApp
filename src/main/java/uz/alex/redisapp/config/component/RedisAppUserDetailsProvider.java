package uz.alex.redisapp.config.component;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uz.alex.redisapp.entity.UserEntity;
import uz.alex.redisapp.model.AuthenticationDetailsDto;
import uz.alex.redisapp.repository.UserRepository;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class RedisAppUserDetailsProvider implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.map(
                            user -> new AuthenticationDetailsDto(user.getId(), user.getUsername(), user.getPassword()))
                    .get();
        } else {
            throw new UsernameNotFoundException(
                    String.format("User not exists by Username or Email : [%s]", username)
            );
        }
    }
}
