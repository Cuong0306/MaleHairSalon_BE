package com.BE.controller;

import com.BE.model.entity.Admin;
import com.BE.model.request.AdminRequest;
import com.BE.service.AdminService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
@SecurityRequirement(name ="api")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Admin> create(@RequestBody AdminRequest adminRequest) {
        Admin newAdmin = adminService.create(adminRequest);
        return ResponseEntity.ok(newAdmin);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Admin>> getAll() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> update(@PathVariable long id, @RequestBody AdminRequest adminRequest) {
        Admin updatedAdmin = adminService.update(id, adminRequest);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Admin> delete(@PathVariable long id) {
        Admin deletedAdmin = adminService.delete(id);
        return ResponseEntity.ok(deletedAdmin);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }
}