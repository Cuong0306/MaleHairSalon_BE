package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Admin;
import com.BE.model.entity.User;
import com.BE.model.request.AdminRequest;
import com.BE.model.response.AdminResponse;
import com.BE.repository.AdminRepository;
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
    UserRepository userRepository;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AdminRepository adminRepository;

    // Create admin
    public AdminResponse createAdmin(AdminRequest adminRequest) {
        Admin admin = adminMapper.toAdmin(adminRequest);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Admin savedAdmin = adminRepository.save(admin);
        return adminMapper.toAdminResponse(savedAdmin);
    }

        // Get all admin
    public List<AdminResponse> getAllAdmins() {
        List<Admin> adminList = adminRepository.findAll();
        return adminList.stream().map(adminMapper::toAdminResponse)
                .collect(Collectors.toList());
    }

        // Get a admin by ID
    public AdminResponse getAdminById(UUID id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
        return adminMapper.toAdminResponse(admin);
    }

        // Update a admin
    public AdminResponse updateAdmin(UUID id, AdminRequest adminRequest) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));

        adminMapper.updateAdmin(existingAdmin, adminRequest);
        if (adminRequest.getPassword() != null && !adminRequest.getPassword().isEmpty()) {
            existingAdmin.setPassword(passwordEncoder.encode(adminRequest.getPassword()));
        }
        Admin savedUser = adminRepository.save(existingAdmin);
        return adminMapper.toAdminResponse(existingAdmin);
    }

        //  Delete a admin
    public void deleteAdmin(UUID id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
        adminRepository.delete(admin);
    }
}
