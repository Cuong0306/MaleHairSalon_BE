package com.BE.repository;

import com.BE.model.entity.Booking;
import com.BE.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findById(long id);
}
