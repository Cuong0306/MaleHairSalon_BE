package com.BE.controller;

import com.BE.model.entity.ServiceEntity;
import com.BE.model.entity.Stylist;
import com.BE.model.request.ServiceRequest;
import com.BE.model.request.StylistRequest;
import com.BE.service.StylistService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stylist")
@CrossOrigin("*") //cors: cho phep fe moi dc truy cap
@SecurityRequirement(name = "api")
//@PreAuthorize("hasAuthority('STYLIST')")

public class StylistController {
    @Autowired
    StylistService stylistService;

    // create stylist
    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody StylistRequest stylist) {
        Stylist newStylist = stylistService.create(stylist);
        return ResponseEntity.ok(newStylist);
    }

    //get all stylist
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Stylist> stylists = stylistService.getAllStylists();
        return ResponseEntity.ok(stylists);

    }

    //update
    @PutMapping("/udate/{id}")
    public ResponseEntity update(@PathVariable long id,@Valid @RequestBody StylistRequest stylist) {
        Stylist updateStylist = stylistService.update(id, stylist);
        return ResponseEntity.ok(updateStylist);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Stylist deleteStylist = stylistService.delete(id);
        return ResponseEntity.ok(deleteStylist);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getStylistById(@PathVariable long id) {
        Stylist getStylistId = stylistService.getStylistById(id);
        return ResponseEntity.ok(getStylistId);
    }

}
