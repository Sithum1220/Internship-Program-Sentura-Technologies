package com.senturatechnologies.internshipprogram.backend.api;

import com.senturatechnologies.internshipprogram.backend.dto.UserDTO;
import com.senturatechnologies.internshipprogram.backend.entity.User;
import com.senturatechnologies.internshipprogram.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        try {
            User user = modelMapper.map(userDTO, User.class);
            return ResponseEntity.ok(userService.createUser(user));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error creating user: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<String> listUsers() {
        try {
            return ResponseEntity.ok(userService.listUsers());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error listing users: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<String> getUserDetails(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(userService.getUserDetails(userId));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error getting user details: " + e.getMessage());
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        try {
            User user = modelMapper.map(userDTO, User.class);
            return ResponseEntity.ok(userService.updateUser(userId, user));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error updating user: " + e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(userService.deleteUser(userId));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }
    }
}
