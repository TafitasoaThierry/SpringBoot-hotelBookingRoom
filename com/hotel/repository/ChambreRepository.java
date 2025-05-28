package com.hotel.repository;

import com.hotel.model.Chambre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, String> {}
