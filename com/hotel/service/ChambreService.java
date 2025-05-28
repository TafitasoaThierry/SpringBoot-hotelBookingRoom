package com.hotel.service;

import com.hotel.model.Chambre;
import com.hotel.repository.ChambreRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChambreService {
	final ChambreRepository chambreRepository;

	public ChambreService(ChambreRepository chambreRepository) {
		this.chambreRepository = chambreRepository;
	}

	public Chambre addChambre(Chambre newChambre) {
		return this.chambreRepository.save(newChambre);
	}

	public List<Chambre> getChambreList() {
		return this.chambreRepository.findAll();
	}

	public String deleteChambre(String numero) {
		if(this.chambreRepository.findById(numero).isPresent()) {
			this.chambreRepository.deleteById(numero);
			return "chambre deleted";
		}else {
			return numero.toString() + " isn't in chambre list";
		}
	}

	public Chambre updateChambre(String numero, Chambre newChambreInfo) {
		if(this.chambreRepository.findById(numero).isPresent()) {
			Chambre chambreInfo = this.chambreRepository.findById(numero).get();
			chambreInfo.setType(newChambreInfo.getType());
			chambreInfo.setStatus(newChambreInfo.getStatus());
			chambreInfo.setPrix(newChambreInfo.getPrix());
			return this.chambreRepository.save(chambreInfo);
		}else {
			throw new ELException(numero.toString() + " isn't in chambre list");
		}
	}
}
