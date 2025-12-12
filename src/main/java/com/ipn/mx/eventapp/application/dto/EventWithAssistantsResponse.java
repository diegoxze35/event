package com.ipn.mx.eventapp.application.dto;

import com.ipn.mx.eventapp.domain.entities.EventEntity;

import java.time.LocalDate;
import java.util.List;

public record EventWithAssistantsResponse(
		Long id,
		String name,
		String description,
		LocalDate startDate,
		LocalDate endDate,
		List<AssistantResponse> assistants
) {
	public static EventWithAssistantsResponse fromEntity(EventEntity entity) {
		List<AssistantResponse> assistants = entity.getAssistantEntities() != null ?
				entity.getAssistantEntities().stream()
						.map(AssistantResponse::fromEntity)
						.toList() : List.of();
		
		return new EventWithAssistantsResponse(
				entity.getId(),
				entity.getName(),
				entity.getDescription(),
				entity.getStartDate(),
				entity.getEndDate(),
				assistants
		);
	}
}
