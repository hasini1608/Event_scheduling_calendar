package com.eventscheduler.coreservices.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventscheduler.coreservices.models.Events;
import com.eventscheduler.coreservices.services.EventsService;

@RestController
@RequestMapping("/events")

public class EventsController {

    @Autowired
    EventsService eventsService;


    @PostMapping("/create")
    public Events createEvent(
            @RequestBody Events event){

        return eventsService.createEvent(event);

    }

    @GetMapping("/all")
    public List<Events> getAllEvents(){

        return eventsService.getAllEvents();

    }

    @DeleteMapping("/delete/{id}")
    public Map<String,String> deleteEvent(
            @PathVariable Long id){

        eventsService.deleteEvent(id);

        return Map.of(
            "message",
            "Deleted Successfully"
        );
    }
    
    @PutMapping("/update/{id}")
    public Events updateEvent(
            @PathVariable Long id,
            @RequestBody Events event){

        return eventsService.updateEvent(id,event);
    }
}