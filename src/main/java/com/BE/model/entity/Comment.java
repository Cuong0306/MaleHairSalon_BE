package com.BE.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String content;
    int rating; // Assuming rating is an integer value

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = true)
    ServiceEntity service;

    @ManyToOne
    @JoinColumn(name = "stylist_id", nullable = true)
    Stylist stylist;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = true)
    Salon salon;

    boolean isDeleted = false;
}