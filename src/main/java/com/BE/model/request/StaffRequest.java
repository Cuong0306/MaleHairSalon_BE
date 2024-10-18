package com.BE.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffRequest {
    String fullName;
    String email;
    String username;
    String password;
    String experience;
    String certifications;
    float rating;
    String availability;
    BigDecimal salary;
    BigDecimal commissionRate;
}