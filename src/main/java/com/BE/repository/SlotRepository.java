package com.BE.repository;

import com.BE.model.entity.ServiceEntity;
import com.BE.model.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    Slot findById(long id);
}
