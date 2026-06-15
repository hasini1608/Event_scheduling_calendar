package com.eventscheduler.coreservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.eventscheduler.coreservices.models.Users;
import com.eventscheduler.coreservices.services.UsersService;
import com.eventscheduler.coreservices.repository.UsersRepository;
import com.eventscheduler.coreservices.jwt.JwtUtil;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    JwtUtil jwtUtil;
    
    @GetMapping("/all")
    public List<Users> getAllUsers(){

        return usersRepository.findAll();

    }
    
    @PostMapping("/signup")
    public Users signup(
            @RequestBody Users user){

        return usersService.saveUser(user);

    }

    @PostMapping("/login")
    public Map<String,Object> login(
            @RequestBody Users user){

        Users existingUser =
                usersService.login(
                        user.getEmail(),
                        user.getPassword());

        Map<String,Object> response =
                new HashMap<>();

        if(existingUser != null){

            String token =
                    jwtUtil.generateToken(
                            existingUser.getEmail());

            response.put("id", existingUser.getId());
            response.put("message","Login Success");
            response.put("token",token);
            response.put("role",existingUser.getRole());
            
            response.put(
                    "name",
                    existingUser.getName()
                );


        }
        else{

            response.put(
                    "message",
                    "Invalid Credentials");
        }

        return response;
    }
}