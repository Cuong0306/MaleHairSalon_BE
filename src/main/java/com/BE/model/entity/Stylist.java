package com.BE.model.entity;

import com.BE.enums.RoleEnum;
import jakarta.persistence.*;
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
    long id;

    String stylistName;

    String stylistExp;

    String Certifications;

    float Rating;

    //Days/hours the stylist is available
    String Availability;

    String info;

    String location;

    boolean isDelete = false;

    @Enumerated(value = EnumType.STRING)
    RoleEnum role;
}
