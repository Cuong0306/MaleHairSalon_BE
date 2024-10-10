package com.BE.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "bookings")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String userName;
    String userPhone;
    LocalDateTime bookingTime;
    BigDecimal totalAmount;
    BigDecimal tipAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stylistID")
    Stylist stylist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serviceID")
    ServiceEntity service;
}
