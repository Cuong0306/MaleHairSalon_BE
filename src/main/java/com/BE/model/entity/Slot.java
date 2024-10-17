package com.BE.model.entity;

import com.BE.enums.RoleEnum;
import com.BE.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String startTime;

    String endTime;

    StatusEnum Status;

    boolean isDelete;

}
