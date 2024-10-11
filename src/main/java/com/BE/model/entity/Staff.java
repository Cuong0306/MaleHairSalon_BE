package com.BE.model.entity;

import com.BE.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.management.relation.Role;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String fullName;
    String email;
    String username;
    String password;
    boolean isDelete = false;

    @Enumerated(value = EnumType.STRING)
    RoleEnum role;
}