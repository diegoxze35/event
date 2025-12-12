package com.ipn.mx.eventapp.domain.ports;

import com.ipn.mx.eventapp.domain.entities.AssistantEntity;

import java.util.List;
import java.util.Optional;

public interface AssistantRepository {
	AssistantEntity save(AssistantEntity assistant);
	
	List<AssistantEntity> findByEventId(Long eventId);
	
	Optional<AssistantEntity> findById(Long id);
	
	void deleteById(Long id);
	
	boolean existsByEmailAndEventId(String email, Long eventId);
	boolean existsById(Long assistantId);
}
