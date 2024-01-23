package com.project.questapp.services.concretes;

import com.project.questapp.core.utilities.mappers.ModelMapperService;
import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.services.abstracts.UserService;
import com.project.questapp.services.dtos.requests.User.UserCreateRequest;
import com.project.questapp.services.dtos.requests.User.UserUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public void addUser(UserCreateRequest userCreateRequest) {
        User user = modelMapperService.forRequest().map(userCreateRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserUpdateRequest userUpdateRequest) {
        User userToUpdate = userRepository.findById(userUpdateRequest.getId()).orElseThrow();
        userToUpdate.setUsername(userUpdateRequest.getUsername());
        userToUpdate.setPassword(userUpdateRequest.getPassword());
        userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
