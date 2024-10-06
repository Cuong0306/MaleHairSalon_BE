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
        AdminService adminService;

        // Create
    @PostMapping("/create")
    public ResponseEntity<AdminResponse> createAdmin(@Valid @RequestBody AdminRequest adminRequest) {
        AdminResponse response = adminService.createAdmin(adminRequest);
        return ResponseEntity.ok(response);
    }

        // Get all users
    @GetMapping("/getAll")
    public ResponseEntity<List<AdminResponse>> getAllAdmins() {
        List<AdminResponse> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

        // Get users by id
    @GetMapping("/getById")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable UUID id) {
        AdminResponse admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

        // Update a user
    @PutMapping("/update")
    public ResponseEntity<AdminResponse> updateAdmin(@PathVariable UUID id, @Valid @RequestBody AdminRequest adminRequest) {
        AdminResponse updateAdmin = adminService.updateAdmin(id, adminRequest);
        return ResponseEntity.ok(updateAdmin);
    }
        // Delete a user
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAdmin(@PathVariable UUID id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
