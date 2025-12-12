package com.ipn.mx.eventapp.infrastructure.persistence.jpa;

import com.ipn.mx.eventapp.domain.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventEntity, Long> {
}
