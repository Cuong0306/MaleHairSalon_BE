package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.ServiceEntity;
import com.BE.model.request.ServiceRequest;
import com.BE.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    //create
    public ServiceEntity create(ServiceRequest service) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setServiceName(service.getServiceName());
        serviceEntity.setServicePrice(service.getServicePrice());
        serviceEntity.setServiceDescription(service.getServiceDescription());
        serviceEntity.setServiceType(service.getServiceType());


        ServiceEntity newService = serviceRepository.save(serviceEntity);
        return newService;
    }

    //read all service
    public List<ServiceEntity> getAllService() {
        List<ServiceEntity> services = serviceRepository.findAll();
        return services;
    }

    //update
    public ServiceEntity update(int id, ServiceRequest service) {
        //b1: Tim ra service can update
        ServiceEntity oldService = getServiceEntityById(id);

        //co ton tai

        oldService.setServiceName(service.getServiceName());
        oldService.setServiceDescription(service.getServiceDescription());
        oldService.setServicePrice(service.getServicePrice());
        oldService.setServiceType(service.getServiceType());

        return serviceRepository.save(oldService);

    }
    //Delete
    public ServiceEntity delete(int id) {
        ServiceEntity oldService = getServiceEntityById(id);
        oldService.setDelete(true);
        return serviceRepository.save(oldService);
    }


    public ServiceEntity getServiceEntityById(int id) {
        ServiceEntity oldService = serviceRepository.findByServiceID(id);
        if(oldService == null) {
            throw new NotFoundException("Service not found");
        }
        return oldService;
    }
    public  ServiceEntity getServiceById(int id) {
        ServiceEntity getServiceId = getServiceEntityById(id);

        return serviceRepository.save(getServiceId);
    }
    /*public ServiceEntity getServiceByName(String name) {
        ServiceEntity serviceName = getServiceByName(name);
        if(serviceName == null) {
            throw new NotFoundException("Service not found");
        }
        return serviceName;
    }*/

}
