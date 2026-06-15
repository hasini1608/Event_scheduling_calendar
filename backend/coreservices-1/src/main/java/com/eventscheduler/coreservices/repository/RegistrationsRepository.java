package com.eventscheduler.coreservices.repository;

import com.eventscheduler.coreservices.models.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationsRepository
        extends JpaRepository<Registrations, Long> {

}