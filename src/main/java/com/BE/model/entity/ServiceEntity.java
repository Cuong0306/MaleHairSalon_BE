package com.BE.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int serviceID;

    @Column(nullable = false)
    String serviceName;

    @Column(length = 500)
    String serviceDescription;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal servicePrice;

    String serviceType;

    boolean isDelete = false;


}
