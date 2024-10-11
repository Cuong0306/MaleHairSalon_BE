package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Admin;
import com.BE.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll().stream()
                .filter(admin -> !admin.isDeleted())
                .toList();
    }

    public Admin update(UUID id, Admin adminDetails) {
        Admin admin = getAdminById(id);
        admin.setAdminName(adminDetails.getAdminName());
        admin.setAdminEmail(adminDetails.getAdminEmail());
        return adminRepository.save(admin);
    }

    public Admin delete(UUID id) {
        Admin admin = getAdminById(id);
        admin.setDeleted(true);
        return adminRepository.save(admin);
    }

    public Admin getAdminById(UUID id) {
        return adminRepository.findByAdminID(id)
                .orElseThrow(() -> new NotFoundException("Admin not found"));
    }
}