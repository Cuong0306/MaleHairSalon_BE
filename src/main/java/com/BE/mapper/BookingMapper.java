package com.BE.mapper;

import com.BE.model.entity.Booking;
import com.BE.model.request.AuthenticationRequest;
import com.BE.model.response.AuthenticationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface BookingMapper {
    Booking toBooking(AuthenticationRequest request);
    AuthenticationResponse toAuthenticationResponse(Booking booking);
    void updateBooking(@MappingTarget Booking booking, AuthenticationRequest request);
}
