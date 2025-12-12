package com.ipn.mx.eventapp.application.dto;

import com.ipn.mx.eventapp.domain.entities.AssistantEntity;

import java.time.LocalDate;

public record AssistantResponse(
		Long id,
		String name,
		String paternalSurname,
		String maternalSurname,
		String email,
		LocalDate registeredDate,
		Long eventId
) {
	public static AssistantResponse fromEntity(AssistantEntity entity) {
		return new AssistantResponse(
				entity.getId(),
				entity.getName(),
				entity.getPaternalSurname(),
				entity.getMaternalSurname(),
				entity.getEmail(),
				entity.getRegisteredDate(),
				entity.getEventEntity().getId()
		);
	}
}
