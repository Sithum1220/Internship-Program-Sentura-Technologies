package com.senturatechnologies.internshipprogram.backend.service;

import com.senturatechnologies.internshipprogram.backend.dto.UserDTO;
import com.senturatechnologies.internshipprogram.backend.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    String createUser(User user) throws IOException;
    String listUsers() throws IOException;
    String getUserDetails(String userId) throws IOException;
    String updateUser(String userId, User user) throws IOException;
    String deleteUser(String userId) throws IOException;
}
