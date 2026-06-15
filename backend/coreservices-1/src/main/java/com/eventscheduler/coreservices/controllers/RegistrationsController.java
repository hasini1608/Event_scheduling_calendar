package com.eventscheduler.coreservices.controllers;

import com.eventscheduler.coreservices.models.Registrations;
import com.eventscheduler.coreservices.services.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/registrations")
@CrossOrigin(origins = "*")
public class RegistrationsController {

    @Autowired
    private RegistrationsService registrationService;

    @PostMapping("/create")
    public Registrations registerEvent(
            @RequestBody Registrations registration) {

        return registrationService.registerEvent(registration);
    }
    
    @GetMapping("/all")
    public List<Registrations> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteRegistration(
            @PathVariable Long id) {

        registrationService.deleteRegistration(id);

        return "Registration deleted successfully";
    }
}