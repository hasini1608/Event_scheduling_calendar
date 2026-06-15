package com.eventscheduler.coreservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventscheduler.coreservices.models.Users;

@Repository
public interface UsersRepository
        extends JpaRepository<Users,Long>{

    Users findByEmailAndPassword(
            String email,
            String password
    );

    Users findByEmail(
            String email
    );
}