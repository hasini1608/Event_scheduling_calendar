package com.eventscheduler.coreservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventscheduler.coreservices.models.Events;
import java.time.LocalDate;
import java.util.List;

public interface EventsRepository
extends JpaRepository<Events,Long>{

	List<Events> findByEventDate(
			LocalDate eventDate
			);
	
}
