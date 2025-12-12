package com.ipn.mx.eventapp.application.services.impl;

import com.ipn.mx.eventapp.application.dto.AssistantRequest;
import com.ipn.mx.eventapp.application.dto.AssistantResponse;
import com.ipn.mx.eventapp.application.services.AssistantService;
import com.ipn.mx.eventapp.application.services.EmailService;
import com.ipn.mx.eventapp.domain.entities.AssistantEntity;
import com.ipn.mx.eventapp.domain.entities.EventEntity;
import com.ipn.mx.eventapp.domain.ports.AssistantRepository;
import com.ipn.mx.eventapp.domain.ports.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssistantServiceImpl implements AssistantService {
	
	private final AssistantRepository assistantRepository;
	private final EventRepository eventRepository;
	private final EmailService emailService;
	
	public AssistantServiceImpl(AssistantRepository assistantRepository,
	                            EventRepository eventRepository,
	                            EmailService emailService) {
		this.assistantRepository = assistantRepository;
		this.eventRepository = eventRepository;
		this.emailService = emailService;
	}
	
	public AssistantResponse registerAssistant(Long eventId, AssistantRequest request) {
		EventEntity event = eventRepository.findById(eventId)
				.orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
		
		// Check if email is already registered for this event
		if (assistantRepository.existsByEmailAndEventId(request.email(), eventId)) {
			throw new RuntimeException("Email already registered for this event");
		}
		
		AssistantEntity assistant = request.toEntity(event);
		AssistantEntity savedAssistant = assistantRepository.save(assistant);
		
		// Send confirmation email asynchronously
		emailService.sendRegistrationConfirmation(savedAssistant);
		
		return AssistantResponse.fromEntity(savedAssistant);
	}
	
	public List<AssistantResponse> getAssistantsByEvent(Long eventId) {
		if (!eventRepository.existsById(eventId)) {
			throw new RuntimeException("Event not found with id: " + eventId);
		}
		
		return assistantRepository.findByEventId(eventId).stream()
				.map(AssistantResponse::fromEntity)
				.toList();
	}
	
	public void deleteAssistant(Long assistantId) {
		if (!assistantRepository.existsById(assistantId)) {
			throw new RuntimeException("Assistant not found with id: " + assistantId);
		}
		assistantRepository.deleteById(assistantId);
	}
}
