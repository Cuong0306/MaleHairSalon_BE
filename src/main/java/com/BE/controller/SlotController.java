package com.BE.controller;

import com.BE.model.entity.Salon;
import com.BE.model.entity.Slot;
import com.BE.model.request.SalonRequest;
import com.BE.model.request.SlotRequest;
import com.BE.service.SalonService;
import com.BE.service.SlotService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slot")
@CrossOrigin("*") //cors: cho phep fe moi dc truy cap
@SecurityRequirement(name = "api")
public class SlotController {
    @Autowired
    SlotService slotService;


    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody SlotRequest slot) {
        Slot newSlot = slotService.create(slot);
        return ResponseEntity.ok(newSlot);
    }

    //get all salon
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Slot> Slots = slotService.getAllSlot();
        return ResponseEntity.ok(Slots);

    }

    //update
    @PutMapping("/udate/{id}")
    public ResponseEntity update(@PathVariable long id,@Valid @RequestBody SlotRequest slot) {
        Slot updateSlot = slotService.update(id, slot);
        return ResponseEntity.ok(updateSlot);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Slot deleteSlot = slotService.delete(id);
        return ResponseEntity.ok(deleteSlot);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getSlotById(@PathVariable long id) {
        Slot getSlotId = slotService.getSlotId(id);
        return ResponseEntity.ok(getSlotId);
    }
}
