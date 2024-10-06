package com.BE.model.entity;


import com.BE.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    String fullName;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String username;

    String password;

    @Enumerated(value = EnumType.STRING)
    RoleEnum role;

}
