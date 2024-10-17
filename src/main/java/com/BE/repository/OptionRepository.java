package com.BE.repository;

import com.BE.model.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<OptionEntity, Long>{
    OptionEntity findById(long id);
}
