package com.neerajkumar.project.springbootrestapi.services;

import com.neerajkumar.project.springbootrestapi.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUserById(Long id);
}
