package com.BE.controller;

import com.BE.model.entity.Staff;
import com.BE.model.request.StaffRequest;
import com.BE.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin("*")
public class StaffController {
    @Autowired
    StaffService staffService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody StaffRequest staff) {
        Staff newStaff = staffService.create(staff);
        return ResponseEntity.ok(newStaff);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Staff> staffList = staffService.getAllStaff();
        return ResponseEntity.ok(staffList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable long id, @Valid @RequestBody StaffRequest staff) {
        Staff updatedStaff = staffService.update(id, staff);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Staff deletedStaff = staffService.delete(id);
        return ResponseEntity.ok(deletedStaff);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getStaffById(@PathVariable long id) {
        Staff staff = staffService.getStaffById(id);
        return ResponseEntity.ok(staff);
    }
}