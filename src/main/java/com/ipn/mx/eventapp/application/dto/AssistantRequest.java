package com.ipn.mx.eventapp.application.dto;

import com.ipn.mx.eventapp.domain.entities.AssistantEntity;
import com.ipn.mx.eventapp.domain.entities.EventEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AssistantRequest(
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    String name,
    
    @NotBlank(message = "Paternal surname is required")
    @Size(min = 2, max = 50, message = "Paternal surname must be between 2 and 50 characters")
    String paternalSurname,
    
    @NotBlank(message = "Maternal surname is required")
    @Size(min = 2, max = 50, message = "Maternal surname must be between 2 and 50 characters")
    String maternalSurname,
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email
) {
    public AssistantEntity toEntity(EventEntity event) {
        AssistantEntity assistant = new AssistantEntity();
        assistant.setName(this.name());
        assistant.setPaternalSurname(this.paternalSurname());
        assistant.setMaternalSurname(this.maternalSurname());
        assistant.setEmail(this.email());
        assistant.setRegisteredDate(LocalDate.now());
        assistant.setEventEntity(event);
        return assistant;
    }
}
