package com.BE.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int SalonID;

    String SalonContact;

    String SalonLocation;

    String OpeningHours;

    String ServicesOffered;

    int Capacity;

    boolean isDelete = false;

}
