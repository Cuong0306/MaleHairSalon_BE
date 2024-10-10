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
public class Stylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int stylistID;

    String stylistName;

    String stylistExp;

    String Specialization;

    int ServiceID;


}
