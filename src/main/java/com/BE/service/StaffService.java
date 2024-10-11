package com.BE.service;

import com.BE.enums.RoleEnum;
import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Staff;
import com.BE.model.request.StaffRequest;
import com.BE.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public Staff create(StaffRequest staff) {
        Staff newStaff = new Staff();
        newStaff.setFullName(staff.getFullName());
        newStaff.setEmail(staff.getEmail());
        newStaff.setUsername(staff.getUsername());
        newStaff.setPassword(staff.getPassword());
        newStaff.setRole(RoleEnum.STAFF);
        return staffRepository.save(newStaff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff update(long id, StaffRequest staff) {
        Staff existingStaff = getStaffById(id);
        existingStaff.setFullName(staff.getFullName());
        existingStaff.setEmail(staff.getEmail());
        existingStaff.setUsername(staff.getUsername());
        existingStaff.setPassword(staff.getPassword());
        return staffRepository.save(existingStaff);
    }

    public Staff delete(long id) {
        Staff existingStaff = getStaffById(id);
        existingStaff.setDelete(true);
        return staffRepository.save(existingStaff);
    }

    public Staff getStaffById(long id) {
        Staff staff = staffRepository.findById(id);
        if (staff == null) {
            throw new NotFoundException("Staff not found");
        }
        return staff;
    }
}