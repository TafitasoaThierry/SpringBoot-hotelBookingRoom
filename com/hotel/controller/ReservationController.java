package com.hotel.controller;

import java.util.List;

import com.hotel.model.Reservation;
import com.hotel.service.ReservationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin()
public class ReservationController {
	final ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	/*
	 * use Reservation service
	 */
	@PostMapping("/addReservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation newReservation) {
		return ResponseEntity.ok(this.reservationService.addReservation(newReservation));
	}

	@GetMapping("/getReservationList")
	public ResponseEntity<List<Reservation>> getreservationList() {
		return ResponseEntity.ok(this.reservationService.getReservationList());
	}

	@DeleteMapping("/deleteReservation/{reference}")
	public ResponseEntity<String> deleteReservation(@PathVariable Long reference) {
		return ResponseEntity.ok(this.reservationService.deleteReservation(reference));
	}

	@PutMapping("/updateReservation/{reference}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable Long reference, @RequestBody Reservation newReservationInfo) {
		return ResponseEntity.ok(this.reservationService.updateReservation(reference, newReservationInfo));
	}
}
