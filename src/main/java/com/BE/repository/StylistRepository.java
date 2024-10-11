package com.BE.repository;

import com.BE.model.entity.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StylistRepository extends JpaRepository<Stylist, Long> {

    Stylist findById(long id);



}
