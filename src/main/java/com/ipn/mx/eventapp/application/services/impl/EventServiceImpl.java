package com.ipn.mx.eventapp.application.services.impl;

import com.ipn.mx.eventapp.application.dto.EventRequest;
import com.ipn.mx.eventapp.application.dto.EventResponse;
import com.ipn.mx.eventapp.application.dto.EventWithAssistantsResponse;
import com.ipn.mx.eventapp.application.services.EventService;
import com.ipn.mx.eventapp.domain.entities.EventEntity;
import com.ipn.mx.eventapp.domain.ports.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {
	
	private final EventRepository eventRepository;
	
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public EventResponse createEvent(EventRequest request) {
		validateEventDates(request.startDate(), request.endDate());
		
		EventEntity event = request.toEntity();
		EventEntity savedEvent = eventRepository.save(event);
		
		return EventResponse.fromEntity(savedEvent);
	}
	
	public List<EventResponse> getAllEvents() {
		return eventRepository.findAll().stream()
				.map(EventResponse::fromEntity)
				.toList();
	}
	
	public List<EventWithAssistantsResponse> getAllEventsWithAssistants() {
		return eventRepository.findAll().stream()
				.map(EventWithAssistantsResponse::fromEntity)
				.toList();
	}
	
	public EventResponse updateEvent(Long id, EventRequest request) {
		validateEventDates(request.startDate(), request.endDate());
		
		EventEntity event = eventRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
		
		event.setName(request.name());
		event.setDescription(request.description());
		event.setStartDate(request.startDate());
		event.setEndDate(request.endDate());
		
		EventEntity updatedEvent = eventRepository.save(event);
		return EventResponse.fromEntity(updatedEvent);
	}
	
	public void deleteEvent(Long id) {
		if (!eventRepository.existsById(id)) {
			throw new RuntimeException("Event not found with id: " + id);
		}
		eventRepository.deleteById(id);
	}
	
	private void validateEventDates(LocalDate startDate, LocalDate endDate) {
		if (endDate.isBefore(startDate)) {
			throw new RuntimeException("End date cannot be before start date");
		}
	}
}
