package com.BE.model.entity;

import com.BE.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String fullName;
    String email;
    String username;
    String password;

    @Enumerated(value = EnumType.STRING)
    RoleEnum role = RoleEnum.ADMIN; // Default role set to ADMIN

    boolean isDelete = false;
}