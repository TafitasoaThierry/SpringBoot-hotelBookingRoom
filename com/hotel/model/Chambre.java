package com.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Chambre")
@Getter
@Setter
public class Chambre {
	@Id
	private String numero;
	private String type;
	private String status;
	private int prix;
}
