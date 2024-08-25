package com.senturatechnologies.internshipprogram.backend.service;

import com.senturatechnologies.internshipprogram.backend.dto.UserDTO;
import com.senturatechnologies.internshipprogram.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserDTO> getAllUsers();

    public Optional<User> getUserById(Long id);

    public User createUser(UserDTO user);

    public User updateUser(Long id, UserDTO userDetails);

    public void deleteUser(Long id);
}
