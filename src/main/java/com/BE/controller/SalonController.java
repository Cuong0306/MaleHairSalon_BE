package com.BE.controller;

import com.BE.model.entity.Salon;
import com.BE.model.entity.ServiceEntity;
import com.BE.model.request.SalonRequest;
import com.BE.model.request.ServiceRequest;
import com.BE.service.SalonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salon")
@CrossOrigin("*") //cors: cho phep fe moi dc truy cap
public class SalonController {
    @Autowired
    SalonService salonService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody SalonRequest salon) {
        Salon newSalon = salonService.create(salon);
        return ResponseEntity.ok(newSalon);
    }

    //get all salon
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Salon> salons = salonService.getAllSalon();
        return ResponseEntity.ok(salons);

    }

    //update
    @PutMapping("/udate/{id}")
    public ResponseEntity update(@PathVariable int id,@Valid @RequestBody SalonRequest salon) {
        Salon updateSalon = salonService.update(id, salon);
        return ResponseEntity.ok(updateSalon);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Salon deleteSalon = salonService.delete(id);
        return ResponseEntity.ok(deleteSalon);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getSalonById(@PathVariable int id) {
        Salon getSalonId = salonService.getSalonById(id);
        return ResponseEntity.ok(getSalonId);
    }

}
