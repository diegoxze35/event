package com.ipn.mx.eventapp.infrastructure.persistence;

import com.ipn.mx.eventapp.domain.entities.EventEntity;
import com.ipn.mx.eventapp.domain.ports.EventRepository;
import com.ipn.mx.eventapp.infrastructure.persistence.jpa.EventJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryImpl implements EventRepository {
	
	private final EventJpaRepository eventJpaRepository;
	
	public EventRepositoryImpl(EventJpaRepository eventJpaRepository) {
		this.eventJpaRepository = eventJpaRepository;
	}
	
	@Override
	public EventEntity save(EventEntity event) {
		return eventJpaRepository.save(event);
	}
	
	@Override
	public List<EventEntity> findAll() {
		return eventJpaRepository.findAll();
	}
	
	@Override
	public Optional<EventEntity> findById(Long id) {
		return eventJpaRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		eventJpaRepository.deleteById(id);
	}
	
	@Override
	public boolean existsById(Long id) {
		return eventJpaRepository.existsById(id);
	}
}
