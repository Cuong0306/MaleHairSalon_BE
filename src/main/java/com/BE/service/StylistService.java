package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.ServiceEntity;
import com.BE.model.entity.Stylist;
import com.BE.model.request.ServiceRequest;
import com.BE.model.request.StylistRequest;
import com.BE.repository.ServiceRepository;
import com.BE.repository.StylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class StylistService {
    @Autowired
    StylistRepository stylistRepository;


    //create
    public Stylist create(StylistRequest stylist) {
        Stylist stylist1 = new Stylist();
        stylist1.setStylistName(stylist.getStylistName());
        stylist1.setStylistExp(stylist.getStylistExp());
        stylist1.setCertifications(stylist.getCertifications());
        stylist1.setRating(stylist.getRating());
        stylist1.setAvailability(stylist.getAvailability());
        stylist1.setInfo(stylist.getInfo());
        stylist1.setLocation(stylist.getLocation());


        Stylist newStylist = stylistRepository.save(stylist1);
        return newStylist;
    }

    //read all service
    public List<Stylist> getAllStylists() {
        List<Stylist> stylists = stylistRepository.findAll();
        return stylists;
    }

    //update
    public Stylist update(long id, StylistRequest stylist) {
        //b1: Tim ra service can update
        Stylist oldStylist = getStylistId(id);

        //co ton tai

        oldStylist.setStylistName(stylist.getStylistName());
        oldStylist.setStylistExp(stylist.getStylistExp());
        oldStylist.setCertifications(stylist.getCertifications());
        oldStylist.setRating(stylist.getRating());
        oldStylist.setAvailability(stylist.getAvailability());
        oldStylist.setInfo(stylist.getInfo());
        oldStylist.setLocation(stylist.getLocation());


        return stylistRepository.save(oldStylist);

    }
    //Delete
    public Stylist delete(long id) {
        Stylist oldStylist = getStylistId(id);
        oldStylist.setDelete(true);
        return stylistRepository.save(oldStylist);
    }

    public Stylist getStylistId(long id) {
        Stylist getstylistId = getStylistById(id);
        return stylistRepository.save(getstylistId);
    }

    public Stylist getStylistById(long id) {
        Stylist oldStylist = stylistRepository.findById(id);
        if(oldStylist == null) {
            throw new NotFoundException("Stylist not found");
        }
        return oldStylist;
    }

}
