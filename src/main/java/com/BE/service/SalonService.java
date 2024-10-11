package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Salon;
import com.BE.model.entity.ServiceEntity;
import com.BE.model.entity.Stylist;
import com.BE.model.request.SalonRequest;
import com.BE.model.request.ServiceRequest;
import com.BE.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {
    @Autowired
    SalonRepository salonRepository;
    public Salon create(SalonRequest salon) {
        Salon salon1 = new Salon();
        salon1.setSalonContact(salon.getSalonContact());
        salon1.setSalonLocation(salon.getSalonLocation());
        salon1.setOpeningHours(salon.getOpeningHours());
        salon1.setServicesOffered(salon.getServicesOffered());
        salon1.setCapacity(salon.getCapacity());

        Salon newSalon = salonRepository.save(salon1);
        return salon1;

    }
    public List<Salon> getAllSalon() {
        List<Salon> Salons = salonRepository.findAll();
        return Salons;
    }

    public Salon update(long id, SalonRequest salon) {
        //b1: Tim ra service can update
        Salon oldSalon = getSalonId(id);

        //co ton tai

        oldSalon.setServicesOffered(salon.getServicesOffered());
        oldSalon.setSalonContact(salon.getSalonContact());
        oldSalon.setSalonLocation(salon.getSalonLocation());
        oldSalon.setOpeningHours(salon.getOpeningHours());
        oldSalon.setCapacity(salon.getCapacity());

        return salonRepository.save(oldSalon);

    }
    //Delete
    public Salon delete(long id) {
        Salon oldSalon = getSalonById(id);
        oldSalon.setDelete(true);
        return salonRepository.save(oldSalon);
    }

    public Salon getSalonId(long id) {
        Salon getSalonId = getSalonById(id);
        return salonRepository.save(getSalonId);
    }

    public Salon getSalonById(long id) {
        Salon oldSalon = salonRepository.findById(id);
        if(oldSalon == null) {
            throw new NotFoundException("Salon not found");
        }
        return oldSalon;
    }
}
