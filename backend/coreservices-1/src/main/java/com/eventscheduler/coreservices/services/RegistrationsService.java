package com.eventscheduler.coreservices.services;

import com.eventscheduler.coreservices.models.Registrations;
import com.eventscheduler.coreservices.repository.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistrationsService {

    @Autowired
    private RegistrationsRepository RegistrationsRepository;

    public Registrations registerEvent(
            Registrations registration) {

        return RegistrationsRepository.save(registration);
    }
    
    public List<Registrations> getAllRegistrations() {
        return RegistrationsRepository.findAll();
    }
    
    public void deleteRegistration(Long id) {
        RegistrationsRepository.deleteById(id);
    }
    
}