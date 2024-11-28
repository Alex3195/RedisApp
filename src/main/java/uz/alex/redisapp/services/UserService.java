package uz.alex.redisapp.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.alex.redisapp.entity.UserEntity;
import uz.alex.redisapp.model.UserModel;
import uz.alex.redisapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserModel getUserById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {

            return toModel(optionalUserEntity.get());
        } else throw new EntityNotFoundException("User not found");
    }

    public List<UserModel> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(this::toModel).collect(Collectors.toList());
    }

    private UserModel toModel(UserEntity userEntity) {
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setUsername(userEntity.getUsername());
        return userModel;
    }
}
