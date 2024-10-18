package com.BE.service;

import com.BE.enums.RoleEnum;
import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.User;
import com.BE.model.request.StaffRequest;
import com.BE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StaffService {
    @Autowired
    UserRepository userRepository;

    public User create(StaffRequest staffRequest) {
        User newStaff = new User();
        newStaff.setFullName(staffRequest.getFullName());
        newStaff.setEmail(staffRequest.getEmail());
        newStaff.setUsername(staffRequest.getUsername());
        newStaff.setPassword(staffRequest.getPassword());
        newStaff.setRole(RoleEnum.STAFF);
        newStaff.setExperience(staffRequest.getExperience());
        newStaff.setCertifications(staffRequest.getCertifications());
        newStaff.setRating(staffRequest.getRating());
        newStaff.setAvailability(staffRequest.getAvailability());
        newStaff.setSalary(staffRequest.getSalary());
        newStaff.setCommissionRate(staffRequest.getCommissionRate());
        return userRepository.save(newStaff);
    }

    public List<User> getAllStaff() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() == RoleEnum.STAFF)
                .collect(Collectors.toList());
    }

    public User update(UUID id, StaffRequest staffRequest) {
        User existingStaff = getStaffById(id);
        existingStaff.setFullName(staffRequest.getFullName());
        existingStaff.setEmail(staffRequest.getEmail());
        existingStaff.setUsername(staffRequest.getUsername());
        existingStaff.setPassword(staffRequest.getPassword());
        existingStaff.setExperience(staffRequest.getExperience());
        existingStaff.setCertifications(staffRequest.getCertifications());
        existingStaff.setRating(staffRequest.getRating());
        existingStaff.setAvailability(staffRequest.getAvailability());
        existingStaff.setSalary(staffRequest.getSalary());
        existingStaff.setCommissionRate(staffRequest.getCommissionRate());
        return userRepository.save(existingStaff);
    }

    public User delete(UUID id) {
        User existingStaff = getStaffById(id);
        existingStaff.setRole(RoleEnum.GUEST); // Or set a flag for deletion
        return userRepository.save(existingStaff);
    }

    public User getStaffById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Staff not found"));
    }
}