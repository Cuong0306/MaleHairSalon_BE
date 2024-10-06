package com.BE.controller;


import com.BE.model.request.AdminRequest;
import com.BE.model.response.AdminResponse;
import com.BE.service.AdminService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
@SecurityRequirement(name = "api")
public class AdminController {

        @Autowired
        private AdminService adminService;

        // Create
    @PostMapping("/users")
    public ResponseEntity<AdminResponse> createUser(@Valid @RequestBody AdminRequest adminRequest) {
        AdminResponse response = adminService.createAdmin(adminRequest);
        return ResponseEntity.ok(response);
    }

        // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<AdminResponse>> getAllUsers() {
        List<AdminResponse> users = adminService.getAllAdmins();
        return ResponseEntity.ok(users);
    }

        // Get users by id
    @GetMapping("/users/{id}")
    public ResponseEntity<AdminResponse> getUserById(@PathVariable UUID id) {
        AdminResponse user = adminService.getAdminById(id);
        return ResponseEntity.ok(user);
    }

        // Update a user
    @PutMapping("/users/{id}")
    public ResponseEntity<AdminResponse> updateUser(@PathVariable UUID id, @Valid @RequestBody AdminRequest adminRequest) {
        AdminResponse updateUser = adminService.updateAdmin(id, adminRequest);
        return ResponseEntity.ok(updateUser);
    }
        // Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
