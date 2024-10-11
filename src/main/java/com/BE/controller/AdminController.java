package com.BE.controller;

import com.BE.model.entity.Admin;
import com.BE.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Admin> create(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.create(admin));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Admin>> getAll() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> update(@PathVariable UUID id, @RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.update(id, admin));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Admin> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.delete(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable UUID id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }
}