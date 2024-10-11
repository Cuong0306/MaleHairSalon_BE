package com.BE.service;

import com.BE.enums.RoleEnum;
import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Manager;
import com.BE.model.request.ManagerRequest;
import com.BE.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    public Manager create(ManagerRequest request) {
        Manager manager = new Manager();
        manager.setFullName(request.getFullName());
        manager.setEmail(request.getEmail());
        manager.setUsername(request.getUsername());
        manager.setPassword(request.getPassword());
        manager.setRole(RoleEnum.MANAGER);
        return managerRepository.save(manager);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager update(long id, ManagerRequest request) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new NotFoundException("Manager not found"));
        manager.setUsername(request.getUsername());
        manager.setPassword(request.getPassword());
        // Update other fields
        return managerRepository.save(manager);
    }

    public void delete(long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager not found"));
        manager.setDeleted(true);
        managerRepository.save(manager);
    }

    public Manager getManagerById(long id) {
        return managerRepository.findById(id).orElseThrow(() -> new NotFoundException("Manager not found"));
    }
}