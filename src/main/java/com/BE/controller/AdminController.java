package com.BE.controller;

import com.BE.model.entity.Admin;
import com.BE.model.request.AdminRequest;
import com.BE.service.AdminService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody AdminRequest adminRequest) {
        Admin newAdmin = adminService.create(adminRequest);
        return ResponseEntity.ok(newAdmin);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable long id, @Valid @RequestBody AdminRequest adminRequest) {
        Admin updatedAdmin = adminService.update(id, adminRequest);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Admin deletedAdmin = adminService.delete(id);
        return ResponseEntity.ok(deletedAdmin);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getAdminById(@PathVariable long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }
}