package com.BE.service;

import com.BE.mapper.BookingMapper;
import com.BE.repository.BookingRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;
}
