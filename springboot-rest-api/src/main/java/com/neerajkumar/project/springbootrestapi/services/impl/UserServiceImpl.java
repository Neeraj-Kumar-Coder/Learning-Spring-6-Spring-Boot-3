package com.neerajkumar.project.springbootrestapi.services.impl;

import com.neerajkumar.project.springbootrestapi.entities.User;
import com.neerajkumar.project.springbootrestapi.repositories.UserRepository;
import com.neerajkumar.project.springbootrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) throws RuntimeException {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException(String.format("User with id %ld doesn't exist", id));
        } else {
            return result.get();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exisitingUser = this.getUserById(user.getId());
        exisitingUser.setFirstName(user.getFirstName());
        exisitingUser.setLastName(user.getLastName());
        exisitingUser.setEmail(user.getEmail());
        return userRepository.save(exisitingUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
