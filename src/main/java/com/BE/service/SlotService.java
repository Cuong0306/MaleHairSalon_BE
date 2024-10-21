package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Salon;
import com.BE.model.entity.Slot;
import com.BE.model.request.SalonRequest;
import com.BE.model.request.SlotRequest;
import com.BE.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {
    @Autowired
    SlotRepository slotRepository;
    public Slot create(SlotRequest slot) {
        Slot slot1 = new Slot();
        slot1.setStartTime(slot.getStartTime());
        slot1.setEndTime(slot.getEndTime());
        slot1.setStatus(slot.getStatus());


        Slot newSlot = slotRepository.save(slot1);
        return slot1;

    }
    public List<Slot> getAllSlot() {
        List<Slot> Slots = slotRepository.findAll();
        return Slots;
    }

    public Slot update(long id, SlotRequest salon) {
        //b1: Tim ra service can update
        Slot oldSlot = getSlotByIdById(id);

        //co ton tai

        oldSlot.setStartTime(salon.getStartTime());
        oldSlot.setEndTime(salon.getEndTime());
        oldSlot.setStatus(salon.getStatus());


        return slotRepository.save(oldSlot);

    }
    //Delete
    public Slot delete(long id) {
        Slot oldSlot = getSlotByIdById(id);
        oldSlot.setDelete(true);
        return slotRepository.save(oldSlot);
    }

    public Slot getSlotId(long id) {
        Slot getSlotId = getSlotByIdById(id);
        return slotRepository.save(getSlotId);
    }

    public Slot getSlotByIdById(long id) {
        Slot oldSlot = slotRepository.findById(id);
        if(oldSlot == null) {
            throw new NotFoundException("Salon not found");
        }
        return oldSlot;
    }
}
