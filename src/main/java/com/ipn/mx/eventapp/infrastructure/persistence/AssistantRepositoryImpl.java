package com.ipn.mx.eventapp.infrastructure.persistence;

import com.ipn.mx.eventapp.domain.entities.AssistantEntity;
import com.ipn.mx.eventapp.domain.ports.AssistantRepository;
import com.ipn.mx.eventapp.infrastructure.persistence.jpa.AssistantJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AssistantRepositoryImpl implements AssistantRepository {
    
    private final AssistantJpaRepository assistantJpaRepository;
    
    public AssistantRepositoryImpl(AssistantJpaRepository assistantJpaRepository) {
        this.assistantJpaRepository = assistantJpaRepository;
    }
    
    @Override
    public AssistantEntity save(AssistantEntity assistant) {
        return assistantJpaRepository.save(assistant);
    }
    
    @Override
    public List<AssistantEntity> findByEventId(Long eventId) {
        return assistantJpaRepository.findByEventEntityId(eventId);
    }
    
    @Override
    public Optional<AssistantEntity> findById(Long id) {
        return assistantJpaRepository.findById(id);
    }
    
    @Override
    public void deleteById(Long id) {
        assistantJpaRepository.deleteById(id);
    }
    
    @Override
    public boolean existsByEmailAndEventId(String email, Long eventId) {
        return assistantJpaRepository.existsByEmailAndEventEntityId(email, eventId);
    }
	
	@Override
	public boolean existsById(Long assistantId) {
		return assistantJpaRepository.existsById(assistantId);
	}
}

