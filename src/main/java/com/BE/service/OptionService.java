package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.OptionEntity;
import com.BE.model.entity.Salon;
import com.BE.model.request.OptionRequest;
import com.BE.model.request.SalonRequest;
import com.BE.repository.OptionRepository;
import com.BE.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    OptionService optionService;
    @Autowired
    private OptionRepository optionRepository;

    public OptionEntity create(OptionRequest option) {
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setName(option.getName());
        optionEntity.setPrice(option.getPrice());

        OptionEntity newOption = optionRepository.save(optionEntity);
        return newOption;

    }
    public List<OptionEntity> getAllOption() {
        List<OptionEntity> OptionEntities = optionRepository.findAll();
        return OptionEntities;
    }

    public OptionEntity update(long id, OptionRequest salon) {
        //b1: Tim ra service can update
        OptionEntity oldOption = getOptionById(id);

        //co ton tai

        oldOption.setName(salon.getName());
        oldOption.setPrice(salon.getPrice());


        return optionRepository.save(oldOption);

    }
    //Delete
    public OptionEntity delete(long id) {
        OptionEntity oldOption = getOptionById(id);
        oldOption.setDelete(true);
        return optionRepository.save(oldOption);
    }

    public OptionEntity getSalonId(long id) {
        OptionEntity getOptionId = getOptionById(id);
        return optionRepository.save(getOptionId);
    }

    public OptionEntity getOptionById(long id) {
        OptionEntity oldOption = optionRepository.findById(id);
        if(oldOption == null) {
            throw new NotFoundException("Salon not found");
        }
        return oldOption;
    }
}
