package com.BE.model.entity;

import com.BE.enums.BookingEnum;
import com.google.type.Decimal;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    LocalDate BookingDate;

    BigDecimal TotalAmount;

    BookingEnum Status;


    @ManyToMany
    @JoinTable(name = "Booking_Service",
            joinColumns = @JoinColumn(name = "BookingID"),
            inverseJoinColumns = @JoinColumn(name = "ServiceID")
    )
    Set<ServiceEntity> serviceEntities;

    @ManyToMany
    @JoinTable(name = "Booking_Stylist",
            joinColumns = @JoinColumn(name = "BookingID"),
            inverseJoinColumns = @JoinColumn(name = "StylistID")
    )
    Set<Stylist> stylists;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    Salon salon; // Thêm thuộc tính liên kết đến Salon

}
