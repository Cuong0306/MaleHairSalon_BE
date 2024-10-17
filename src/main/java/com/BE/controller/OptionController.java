package com.BE.controller;

import com.BE.model.entity.OptionEntity;
import com.BE.model.entity.Salon;
import com.BE.model.request.OptionRequest;
import com.BE.model.request.SalonRequest;
import com.BE.service.OptionService;
import com.BE.service.SalonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Option")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class OptionController {
    @Autowired
    OptionService optionService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody OptionRequest option) {
        OptionEntity newOption = optionService.create(option);
        return ResponseEntity.ok(newOption);
    }

    //get all salon
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<OptionEntity> option = optionService.getAllOption();
        return ResponseEntity.ok(option);

    }

    //update
    @PutMapping("/udate/{id}")
    public ResponseEntity update(@PathVariable long id,@Valid @RequestBody OptionRequest option) {
        OptionEntity updateOption = optionService.update(id, option);
        return ResponseEntity.ok(updateOption);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        OptionEntity deleteOtion = optionService.delete(id);
        return ResponseEntity.ok(deleteOtion);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getSalonById(@PathVariable long id) {
        OptionEntity getOptionId = optionService.getOptionById(id);
        return ResponseEntity.ok(getOptionId);
    }
}
