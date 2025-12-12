package com.ipn.mx.eventapp.domain.ports;

import com.ipn.mx.eventapp.domain.entities.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    EventEntity save(EventEntity event);
    List<EventEntity> findAll();
    Optional<EventEntity> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
