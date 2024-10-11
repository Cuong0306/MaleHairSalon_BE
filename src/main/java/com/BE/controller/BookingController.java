package com.BE.controller;

import com.BE.model.entity.Booking;
import com.BE.model.request.BookingRequest;
import com.BE.service.BookingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
@PreAuthorize("hasRole('USER')")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody BookingRequest bookingRequest) {
        Booking newBooking = bookingService.create(bookingRequest);
        return ResponseEntity.ok(newBooking);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable long id, @Valid @RequestBody BookingRequest bookingRequest) {
        Booking updatedBooking = bookingService.update(id, bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Booking deletedBooking = bookingService.delete(id);
        return ResponseEntity.ok(deletedBooking);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBookingById(@PathVariable long id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }
}