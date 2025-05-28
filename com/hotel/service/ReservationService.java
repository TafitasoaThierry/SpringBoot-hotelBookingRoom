package com.hotel.service;

import com.hotel.model.Reservation;
import com.hotel.repository.ReservationRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	final ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public Reservation addReservation(Reservation newReservation) {
		return this.reservationRepository.save(newReservation);
	}

	public List<Reservation> getReservationList() {
		return this.reservationRepository.findAll();
	}

	public String deleteReservation(Long reference) {
		if(this.reservationRepository.findById(reference).isPresent()) {
			this.reservationRepository.deleteById(reference);
			return "reservation deleted";
		}else {
			return reference.toString() + " isn't in reservation list";
		}
	}

	public Reservation updateReservation(Long reference, Reservation newReservationInfo) {
		if(this.reservationRepository.findById(reference).isPresent()) {
			Reservation reservationInfo = this.reservationRepository.findById(reference).get();
			reservationInfo.setDateDebut(newReservationInfo.getDateDebut());
			reservationInfo.setDateFin(newReservationInfo.getDateFin());
			reservationInfo.setStatus(newReservationInfo.getStatus());
			reservationInfo.setNbPersonne(newReservationInfo.getNbPersonne());
			reservationInfo.setNbChambre(newReservationInfo.getNbChambre());
			reservationInfo.setMatricule(newReservationInfo.getMatricule());
			reservationInfo.setNumeroClient(newReservationInfo.getNumeroClient());
			return this.reservationRepository.save(reservationInfo);
		}else {
			throw new ELException(reference.toString() + " isn't in reservation list");
		}
	}
}
