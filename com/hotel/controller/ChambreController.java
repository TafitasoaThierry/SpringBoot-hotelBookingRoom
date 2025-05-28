package com.hotel.controller;

import java.util.List;

import com.hotel.model.Chambre;
import com.hotel.service.ChambreService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin()
public class ChambreController {
	final ChambreService chambreService;

	public ChambreController(ChambreService chambreService) {
		this.chambreService = chambreService;
	}

	/*
	 * use Chambre service
	 */
	@PostMapping("/addChambre")
	public ResponseEntity<Chambre> addChambre(@RequestBody Chambre newChambre) {
		return ResponseEntity.ok(this.chambreService.addChambre(newChambre));
	}

	@GetMapping("/getChambreList")
	public ResponseEntity<List<Chambre>> getchambreList() {
		return ResponseEntity.ok(this.chambreService.getChambreList());
	}

	@DeleteMapping("/deleteChambre/{numero}")
	public ResponseEntity<String> deleteChambre(@PathVariable String numero) {
		return ResponseEntity.ok(this.chambreService.deleteChambre(numero));
	}

	@PutMapping("/updateChambre/{numero}")
	public ResponseEntity<Chambre> updateChambre(@PathVariable String numero, @RequestBody Chambre newChambreInfo) {
		return ResponseEntity.ok(this.chambreService.updateChambre(numero, newChambreInfo));
	}
}
