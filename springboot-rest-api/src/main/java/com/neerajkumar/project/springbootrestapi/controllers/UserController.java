package com.neerajkumar.project.springbootrestapi.controllers;

import com.neerajkumar.project.springbootrestapi.entities.User;
import com.neerajkumar.project.springbootrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public ResponseEntity<?> findUser(@RequestParam("id") Long id) throws RuntimeException {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<?> deleteUserById(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted Successfully!", HttpStatus.OK);
    }
}
