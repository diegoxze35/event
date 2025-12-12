package com.ipn.mx.eventapp.infrastructure.persistence.jpa;

import com.ipn.mx.eventapp.domain.entities.AssistantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssistantJpaRepository extends JpaRepository<AssistantEntity, Long> {
	List<AssistantEntity> findByEventEntityId(Long eventId);
	
	boolean existsByEmailAndEventEntityId(String email, Long eventId);
}
