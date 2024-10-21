package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Admin;
import com.BE.model.request.AdminRequest;
import com.BE.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin create(AdminRequest adminRequest) {
        Admin admin = new Admin();
        admin.setFullName(adminRequest.getFullName());
        admin.setEmail(adminRequest.getEmail());
        admin.setUsername(adminRequest.getUsername());
        admin.setPassword(adminRequest.getPassword()); // Consider hashing the password
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin update(long id, AdminRequest adminRequest) {
        Admin existingAdmin = getAdminById(id);
        existingAdmin.setFullName(adminRequest.getFullName());
        existingAdmin.setEmail(adminRequest.getEmail());
        existingAdmin.setUsername(adminRequest.getUsername());
        existingAdmin.setPassword(adminRequest.getPassword()); // Consider hashing the password
        return adminRepository.save(existingAdmin);
    }

    public Admin delete(long id) {
        Admin existingAdmin = getAdminById(id);
        existingAdmin.setDelete(true);
        return adminRepository.save(existingAdmin);
    }

    public Admin getAdminById(long id) {
        return adminRepository.findById(id).orElseThrow(() -> new NotFoundException("Admin not found"));
    }
}