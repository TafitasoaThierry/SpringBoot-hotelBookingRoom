package com.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@Getter
@Setter
public class Admin extends com.hotel.model.Personne {
	@Id
	private String matricule;
}
