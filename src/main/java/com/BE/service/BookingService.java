package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.*;
import com.BE.model.request.BookingRequest;
import com.BE.model.request.CategoryRequest;
import com.BE.model.request.ServiceRequest;
import com.BE.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    StylistRepository stylistRepository;

    @Autowired
    SalonRepository salonRepository;

    public Booking create(BookingRequest bookingRequest) {
        Booking booking1 = new Booking();
        booking1.setBookingDate(bookingRequest.getBookingDate());

        // Kiểm tra nếu salonID không null
        if (bookingRequest.getSalonID() != null && !bookingRequest.getSalonID().isEmpty()) {
            // Lấy salon đầu tiên từ danh sách
            Salon salon = salonRepository.findById(bookingRequest.getSalonID().get(0)) // Lấy salon đầu tiên
                    .orElseThrow(() -> new EntityNotFoundException("Salon not found"));
            booking1.setSalon(salon); // Gán salon vào booking
        }

        // Xử lý stylist
        Set<Stylist> stylists = new HashSet<>();
        if (bookingRequest.getStylistId() != null) {
            for (Long id : bookingRequest.getStylistId()) {
                Stylist stylist = stylistRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Stylist not found"));
                stylists.add(stylist);
            }
        }
        booking1.setStylists(stylists); // Gán stylist vào booking

        // Xử lý dịch vụ
        Set<ServiceEntity> serviceEntities = new HashSet<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Long id : bookingRequest.getServicesID()) {
            ServiceEntity serviceEntity = serviceRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Service not found"));
            serviceEntities.add(serviceEntity);
            totalAmount = totalAmount.add(serviceEntity.getServicePrice());
        }
        booking1.setServiceEntities(serviceEntities);
        booking1.setTotalAmount(totalAmount); // Gán tổng tiền vào booking

        Booking newBooking = bookingRepository.save(booking1);
        return newBooking;
    }


    public List<Booking> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    public Booking getBookingId(long id) {
        Booking getBookingId = getBookingById(id);

        return bookingRepository.save(getBookingId);
    }

    //ham dung chung
    public Booking getBookingById(long id) {
        Booking oldBooking = bookingRepository.findById(id);
        if (oldBooking == null) {
            throw new NotFoundException("Booking not found");
        }
        return oldBooking;
    }


}
