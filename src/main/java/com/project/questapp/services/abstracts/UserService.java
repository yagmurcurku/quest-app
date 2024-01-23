package com.project.questapp.services.abstracts;

import com.project.questapp.entities.User;
import com.project.questapp.services.dtos.requests.User.UserCreateRequest;
import com.project.questapp.services.dtos.requests.User.UserUpdateRequest;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long userId);
    void addUser(UserCreateRequest userCreateRequest);
    void updateUser(UserUpdateRequest userUpdateRequest);
    void deleteUser(Long userId);

}
