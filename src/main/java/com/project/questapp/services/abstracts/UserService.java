package com.project.questapp.services.abstracts;

import com.project.questapp.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long userId);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);

}
