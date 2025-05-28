package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.model.Client;
import com.hotel.service.ClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin()
public class ClientController {
	final ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	/*
	 * use Client service
	 */
	@PostMapping("/addClient")
	public ResponseEntity<Client> addClient(@RequestBody Client newClient) {
		return ResponseEntity.ok(this.clientService.addClient(newClient));
	}

	@GetMapping("/getClientList")
	public ResponseEntity<List<Client>> getclientList() {
		return ResponseEntity.ok(this.clientService.getClientList());
	}

	@GetMapping("/getClientByNumeroClient/{numeroClient}")
	public ResponseEntity<Optional<Client>> getClientByNumeroClient(@PathVariable Long numeroClient) {
		return ResponseEntity.ok(this.clientService.getClientByNumeroClient(numeroClient));
	}

	@GetMapping("/getClientByTel/{tel}")
	public ResponseEntity<List<Client>> getclientByTel(@PathVariable String tel) {
		return ResponseEntity.ok(this.clientService.getClientByTel(tel));
	}

	@GetMapping("/getClientByEmail/{email}")
	public ResponseEntity<List<Client>> getclientByEmail(@PathVariable String email) {
		return ResponseEntity.ok(this.clientService.getClientByEmail(email));
	}

	@DeleteMapping("/deleteClient/{numeroClient}")
	public ResponseEntity<String> deleteClient(@PathVariable Long numeroClient) {
		return ResponseEntity.ok(this.clientService.deleteClient(numeroClient));
	}

	@PutMapping("/updateClient/{numeroClient}")
	public ResponseEntity<Client> updateClient(@PathVariable Long numeroClient, @RequestBody Client newClientInfo) {
		return ResponseEntity.ok(this.clientService.updateClient(numeroClient, newClientInfo));
	}
}
