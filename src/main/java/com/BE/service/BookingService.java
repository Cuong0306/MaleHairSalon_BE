package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Booking;
import com.BE.model.request.BookingRequest;
import com.BE.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public Booking create(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setBookingTime(bookingRequest.getBookingTime());
        booking.setServiceName(bookingRequest.getServiceName());
        booking.setStylistName(bookingRequest.getStylistName());
        booking.setUserId(bookingRequest.getUserId());

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking update(long id, BookingRequest bookingRequest) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setBookingTime(bookingRequest.getBookingTime());
        existingBooking.setServiceName(bookingRequest.getServiceName());
        existingBooking.setStylistName(bookingRequest.getStylistName());

        return bookingRepository.save(existingBooking);
    }

    public Booking delete(long id) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setDelete(true);
        return bookingRepository.save(existingBooking);
    }

    public Booking getBookingById(long id) {
        return bookingRepository.findById(id);
    }
}