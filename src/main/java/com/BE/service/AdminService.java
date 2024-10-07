package com.BE.service;

import com.BE.enums.RoleEnum;
import com.BE.enums.StatusEnum;
import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Admin;
import com.BE.model.entity.User;
import com.BE.model.request.AdminLoginRequestDTO;
import com.BE.model.request.AdminRequest;
//import com.BE.model.request.AuthenticationRequest;
import com.BE.model.response.AdminResponse;
import com.BE.model.response.AuthenticationResponse;
import com.BE.repository.AdminRepository;
import com.BE.repository.UserRepository;
import com.BE.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    public AuthenticationResponse authenticateAdmin(AdminLoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername().trim(),
                        request.getPassword().trim()
                )
        );

        Admin admin = (Admin) authentication.getPrincipal();
        AuthenticationResponse authenticationResponse = adminMapper.toAuthenticationResponse(admin);
        authenticationResponse.setToken(jwtService.generateToken(admin));
        return authenticationResponse;
    }

    // Create admin
    public AdminResponse createAdmin(AdminRequest adminRequest) {
        Admin admin = adminMapper.toAdmin(adminRequest);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole(RoleEnum.ADMIN);
        admin.setIsDelete(false); // Set is_delete to false when creating a new admin
        Admin savedAdmin = adminRepository.save(admin);
        return adminMapper.toAdminResponse(savedAdmin);
    }

    // Get all admin
    public List<AdminResponse> getAllAdmins() {
        List<Admin> adminList = adminRepository.findAll();
        return adminList.stream().map(adminMapper::toAdminResponse)
                .collect(Collectors.toList());
    }

    // Get admin by ID
    public AdminResponse getAdminById(UUID id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin not found with ID: " + id));
        return adminMapper.toAdminResponse(admin);
    }

    // Update a admin
    public AdminResponse updateAdmin(UUID id, AdminRequest adminRequest) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Admin not found with ID: " + id));

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
                .orElseThrow(() -> new NotFoundException("Admin not found with ID: " + id));
        adminRepository.delete(admin);
    }

    public AdminResponse updateUserStatus(UUID id, StatusEnum status) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
        user.setStatus(status);
        user.setIsDelete(false); // Ensure is_delete is set when updating user status
        User savedUser = userRepository.save(user);
        return adminMapper.toAdminResponse(savedUser);
    }

    public void deleteUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
        user.setStatus(StatusEnum.INACTIVE);
        user.setIsDelete(true); // Set is_delete to true when deleting a user
        userRepository.save(user);
    }
}
