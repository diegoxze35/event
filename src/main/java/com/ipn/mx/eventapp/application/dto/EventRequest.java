package com.ipn.mx.eventapp.application.dto;

import com.ipn.mx.eventapp.domain.entities.EventEntity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EventRequest(
		@NotBlank(message = "Name is required")
		@Size(min = 2, max = 200, message = "Name must be between 2 and 200 characters")
		String name,
		
		@NotBlank(message = "Description is required")
		@Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
		String description,
		
		@NotNull(message = "Start date is required")
		@FutureOrPresent(message = "Start date must be in the present or future")
		LocalDate startDate,
		
		@NotNull(message = "End date is required")
		LocalDate endDate
) {
	public EventEntity toEntity() {
		return EventEntity.builder()
				.name(this.name())
				.description(this.description())
				.startDate(this.startDate())
				.endDate(this.endDate())
				.build();
	}
}
