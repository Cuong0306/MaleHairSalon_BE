package com.BE.controller;

import com.BE.model.entity.User;
import com.BE.model.request.StaffRequest;
import com.BE.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin("*")
public class StaffController {
    @Autowired
    StaffService staffService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody StaffRequest staffRequest) {
        User newStaff = staffService.create(staffRequest);
        return ResponseEntity.ok(newStaff);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<User> staffList = staffService.getAllStaff();
        return ResponseEntity.ok(staffList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @Valid @RequestBody StaffRequest staffRequest) {
        User updatedStaff = staffService.update(id, staffRequest);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        User deletedStaff = staffService.delete(id);
        return ResponseEntity.ok(deletedStaff);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getStaffById(@PathVariable UUID id) {
        User staff = staffService.getStaffById(id);
        return ResponseEntity.ok(staff);
    }
}