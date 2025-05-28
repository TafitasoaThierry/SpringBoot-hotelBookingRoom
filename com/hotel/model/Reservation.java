package com.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Reservation")
@Getter
@Setter
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ref;
	private String dateReservation;
	private String dateDebut;
	private String dateFin;
	private String status;
	private String type;
	private int nbPersonne;
	private int nbChambre;
	private String matricule;
	private Long numeroClient;
}
