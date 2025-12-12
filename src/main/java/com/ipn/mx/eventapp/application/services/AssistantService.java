package com.ipn.mx.eventapp.application.services;

import com.ipn.mx.eventapp.application.dto.AssistantRequest;
import com.ipn.mx.eventapp.application.dto.AssistantResponse;

import java.util.List;

public interface AssistantService {
	AssistantResponse registerAssistant(Long eventId, AssistantRequest assistant);
	
	List<AssistantResponse> getAssistantsByEvent(Long eventId);
	
	void deleteAssistant(Long assistantId);
}
