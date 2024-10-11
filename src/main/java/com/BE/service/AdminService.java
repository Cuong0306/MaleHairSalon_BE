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
        admin.setAdminName(adminRequest.getAdminName());
        admin.setEmail(adminRequest.getEmail());
        admin.setPassword(adminRequest.getPassword());
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin update(long id, AdminRequest adminRequest) {
        Admin admin = getAdminById(id);
        admin.setAdminName(adminRequest.getAdminName());
        admin.setEmail(adminRequest.getEmail());
        admin.setPassword(adminRequest.getPassword());
        return adminRepository.save(admin);
    }

    public Admin delete(long id) {
        Admin admin = getAdminById(id);
        admin.setDelete(true);
        return adminRepository.save(admin);
    }

    public Admin getAdminById(long id) {
        Admin admin = adminRepository.findById(id);
        if (admin == null) {
            throw new NotFoundException("Admin not found");
        }
        return admin;
    }
}