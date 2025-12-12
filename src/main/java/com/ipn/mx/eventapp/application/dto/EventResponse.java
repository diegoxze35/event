package com.ipn.mx.eventapp.application.dto;

import com.ipn.mx.eventapp.domain.entities.EventEntity;

import java.time.LocalDate;

public record EventResponse(
		Long id,
		String name,
		String description,
		LocalDate startDate,
		LocalDate endDate
) {
	public static EventResponse fromEntity(EventEntity entity) {
		return new EventResponse(
				entity.getId(),
				entity.getName(),
				entity.getDescription(),
				entity.getStartDate(),
				entity.getEndDate()
		);
	}
}
