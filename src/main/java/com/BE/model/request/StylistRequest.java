package com.BE.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StylistRequest {


    String stylistName;

    String stylistExp;

    String Certifications;

    float Rating;

    //Days/hours the stylist is available
    String Availability;

    String info;

    String location;

    String username;
    String password;
}
