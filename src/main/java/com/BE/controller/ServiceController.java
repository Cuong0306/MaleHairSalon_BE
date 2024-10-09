package com.BE.controller;

import com.BE.model.entity.ServiceEntity;
import com.BE.model.request.ServiceRequest;
import com.BE.repository.ServiceRepository;
import com.BE.service.ServiceService;
import com.google.errorprone.annotations.InlineMeValidationDisabled;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin("*") //cors: cho phep fe moi dc truy cap
public class ServiceController {


    @Autowired
    ServiceService serviceService;
    @Autowired
    private ServiceRepository serviceRepository;


    // create service
    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody ServiceRequest service) {
        ServiceEntity newService = serviceService.create(service);
        return ResponseEntity.ok(newService);
    }

    //get all service
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<ServiceEntity> services = serviceService.getAllService();
        return ResponseEntity.ok(services);

    }

    //update
    @PutMapping("/udate/{id}")
    public ResponseEntity update(@PathVariable int id,@Valid @RequestBody ServiceRequest service) {
        ServiceEntity updateService = serviceService.update(id, service);
        return ResponseEntity.ok(updateService);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        ServiceEntity deleteService = serviceService.delete(id);
        return ResponseEntity.ok(deleteService);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getServiceById(@PathVariable int id) {
        ServiceEntity getServiceId = serviceService.getServiceEntityById(id);
        return ResponseEntity.ok(getServiceId);
    }
    /*@GetMapping("/get/{id}")
    public ResponseEntity  findByServiceName(@PathVariable int id) {
        ServiceEntity getServiceId = serviceService.getServiceByName(toString());
        return ResponseEntity.ok(getServiceId);

    }*/


}
