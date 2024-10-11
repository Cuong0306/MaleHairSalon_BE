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
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String fullName;

    @Column(unique = true)
    String email;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @Enumerated(value = EnumType.STRING)
    RoleEnum role = RoleEnum.MANAGER;

    boolean isDeleted = false;
}