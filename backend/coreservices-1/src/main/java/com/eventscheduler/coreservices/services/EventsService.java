package com.eventscheduler.coreservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventscheduler.coreservices.models.Events;
import com.eventscheduler.coreservices.repository.EventsRepository;

@Service
public class EventsService {

    @Autowired
    EventsRepository eventsRepository;


    public Events createEvent(Events event){


    	List<Events> existing =
    	eventsRepository.findByEventDate(
    	        event.getEventDate()
    	);


    	for(Events e : existing){


    	    boolean conflict =
    	        event.getStartTime()
    	        .isBefore(e.getEndTime())
    	        &&
    	        event.getEndTime()
    	        .isAfter(e.getStartTime());


    	    if(conflict){

    	        throw new RuntimeException(
    	            "Event time conflict"
    	        );

    	    }

    	}



    	return eventsRepository.save(event);

    	}
    public List<Events> getAllEvents(){

        return eventsRepository.findAll();

    }

    public void deleteEvent(Long id){

        eventsRepository.deleteById(id);

    }

    public Events updateEvent(Long id, Events updatedEvent) {

        Events existingEvent = eventsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        existingEvent.setTitle(updatedEvent.getTitle());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setEventDate(updatedEvent.getEventDate());
        existingEvent.setStartTime(updatedEvent.getStartTime());
        existingEvent.setEndTime(updatedEvent.getEndTime());
        existingEvent.setVenue(updatedEvent.getVenue());

        return eventsRepository.save(existingEvent);
    }
}