package com.BE.repository;

import com.BE.model.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findById(Long id);
    // Add custom query methods if needed
//    @Query("SELECT m FROM Manager m WHERE m.isDeleted = false")
//    List<Manager> findAll();
}