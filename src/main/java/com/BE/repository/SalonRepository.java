package com.BE.repository;

import com.BE.model.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Integer> {
    @Query("select u from Salon u where u.SalonID=?1")
    Salon findSalonBySalonID(@Param("SalonID")Integer SalonID);

}
