package com.BE.repository;

import com.BE.model.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    // No changes needed here, JpaRepository provides necessary methods
    // dat ten function theo dinh dang JPA cung cap
    //findServiceById(long id)
    ServiceEntity findById(long id);
   // ServiceEntity findByName(String name);
}