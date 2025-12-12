package com.ipn.mx.eventapp.application.services;

import com.ipn.mx.eventapp.application.dto.EventRequest;
import com.ipn.mx.eventapp.application.dto.EventResponse;
import com.ipn.mx.eventapp.application.dto.EventWithAssistantsResponse;

import java.util.List;

public interface EventService {
	EventResponse createEvent(EventRequest event);
	
	List<EventResponse> getAllEvents();
	
	List<EventWithAssistantsResponse> getAllEventsWithAssistants();
	
	EventResponse updateEvent(Long id, EventRequest event);
	
	void deleteEvent(Long id);
}
