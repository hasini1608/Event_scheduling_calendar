package com.eventscheduler.coreservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventscheduler.coreservices.models.Users;
import com.eventscheduler.coreservices.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users saveUser(Users user){

        Users existingUser =
                usersRepository.findByEmail(
                        user.getEmail());

        if(existingUser != null){

            throw new RuntimeException(
                    "Email already exists");
        }

        return usersRepository.save(user);
    }
    
    public Users getUserByEmail(String email) {

        return usersRepository.findByEmail(email);

    }
   
    public Users login(String email, String password){

        return usersRepository
                .findByEmailAndPassword(
                        email,
                        password
                );
    }

}