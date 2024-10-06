package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.User;
import com.BE.model.request.AdminRequest;
import com.BE.model.response.AdminResponse;
import com.BE.repository.UserRepository;
import com.BE.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

        // Create
    public AdminResponse createAdmin(AdminRequest adminRequest) {
        User user = adminMapper.toUser(adminRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return adminMapper.toAdminResponse(savedUser);
    }

        // Get all users
    public List<AdminResponse> getAllAdmins() {
        List<User> users = userRepository.findAll();
        return users.stream().map(adminMapper::toAdminResponse)
                .collect(Collectors.toList());
    }

        // Get a user by ID
    public AdminResponse getAdminById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
        return adminMapper.toAdminResponse(user);
    }

        // Update a user
    public AdminResponse updateAdmin(UUID id, AdminRequest adminRequest) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));

        adminMapper.updateUser(existingUser, adminRequest);
        if (adminRequest.getPasswork() != null && !adminRequest.getPasswork().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(adminRequest.getPasswork()));
        }
        User savedUser = userRepository.save(existingUser);
        return adminMapper.toAdminResponse(savedUser);
    }

        //  Delete a user
    public void deleteAdmin(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
        userRepository.delete(user);
    }
}
