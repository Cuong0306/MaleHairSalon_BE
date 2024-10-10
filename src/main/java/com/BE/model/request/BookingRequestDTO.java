package com.BE.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequestDTO {
    int id;
    String userName;
    String userPhone;
    LocalDateTime bookingTime;
    BigDecimal totalAmount;
    BigDecimal tipAmount;
    String stylistName;
    String serviceName;

}
