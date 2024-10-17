package com.BE.model.request;

import com.google.type.Decimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
    LocalDate BookingDate;

    List<Long> ServicesID;

    List<Long> StylistId;  // Thêm trường để lưu ID của stylist

    List<Long> SalonID;
}
