package com.ipn.mx.eventapp.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assistant", schema = "public")
public class AssistantEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String paternalSurname;
	
	@Column(length = 50, nullable = false)
	private String maternalSurname;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private LocalDate registeredDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EventEntity eventEntity;
	
}
