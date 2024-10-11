package com.BE.controller;

import com.BE.model.entity.Manager;
import com.BE.model.request.ManagerRequest;
import com.BE.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
@CrossOrigin("*")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @PostMapping("/create")
    public ResponseEntity<Manager> create(@RequestBody ManagerRequest request) {
        return ResponseEntity.ok(managerService.create(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Manager>> getAll() {
        return ResponseEntity.ok(managerService.getAllManagers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Manager> update(@PathVariable long id, @RequestBody ManagerRequest request) {
        return ResponseEntity.ok(managerService.update(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        managerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable long id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }
}