package com.ipn.mx.eventapp.infrastructure.controllers;

import com.ipn.mx.eventapp.application.dto.AssistantRequest;
import com.ipn.mx.eventapp.application.dto.AssistantResponse;
import com.ipn.mx.eventapp.application.services.AssistantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events/{eventId}/assistants")
@Validated
public class AssistantController {
	
	private final AssistantService assistantService;
	
	public AssistantController(AssistantService assistantService) {
		this.assistantService = assistantService;
	}
	
	@PostMapping
	public ResponseEntity<AssistantResponse> registerAssistant(
			@PathVariable Long eventId,
			@Valid @RequestBody AssistantRequest request) {
		AssistantResponse response = assistantService.registerAssistant(eventId, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<AssistantResponse>> getAssistantsByEvent(@PathVariable Long eventId) {
		List<AssistantResponse> assistants = assistantService.getAssistantsByEvent(eventId);
		return ResponseEntity.ok(assistants);
	}
	
	@DeleteMapping("/{assistantId}")
	public ResponseEntity<Void> deleteAssistant(@PathVariable Long assistantId) {
		assistantService.deleteAssistant(assistantId);
		return ResponseEntity.noContent().build();
	}
}
