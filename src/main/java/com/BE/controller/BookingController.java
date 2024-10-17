package com.BE.controller;

import com.BE.model.entity.Booking;
import com.BE.model.entity.Category;
import com.BE.model.request.BookingRequest;
import com.BE.model.request.CategoryRequest;
import com.BE.service.BookingService;
import com.BE.service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin("*") //cors: cho phep fe moi dc truy cap

public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("create")
    public ResponseEntity create(@Valid @RequestBody BookingRequest booking) {
        Booking newBooking = bookingService.create(booking);
        return ResponseEntity.ok(newBooking);
    }
    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Booking> bookings = bookingService.getAllBooking();
        return ResponseEntity.ok(bookings);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity getBookingId(@PathVariable long id) {
        Booking getBookingId = bookingService.getBookingById(id);
        return ResponseEntity.ok(getBookingId);
    }
}
