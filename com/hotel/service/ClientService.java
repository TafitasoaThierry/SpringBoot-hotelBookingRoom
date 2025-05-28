package com.hotel.service;

import com.hotel.model.Client;
import com.hotel.repository.ClientRepository;

import jakarta.el.ELException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
	final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client addClient(Client newClient) {
		return this.clientRepository.save(newClient);
	}

	public List<Client> getClientList() {
		return this.clientRepository.findAll();
	}

	public Optional<Client> getClientByNumeroClient(Long numeroClient) {
		return this.clientRepository.findById(numeroClient);
	}

	public List<Client> getClientByTel(String tel) { // par numero telephone
		return this.clientRepository.findAllByTel(tel);
	}

	public List<Client> getClientByEmail(String email) { // par email
		return this.clientRepository.findAllByEmail(email);
	}

	public String deleteClient(Long numeroClient) {
		if(this.clientRepository.findById(numeroClient).isPresent()) {
			this.clientRepository.deleteById(numeroClient);
			return "client deleted";
		}else {
			return numeroClient.toString() + " isn't in client list";
		}
	}

	public Client updateClient(Long numeroClient, Client newClientInfo) {
		if(this.clientRepository.findById(numeroClient).isPresent()) {
			Client clientInfo = this.clientRepository.findById(numeroClient).get();
			return this.clientRepository.save(clientInfo);
		}else {
			throw new ELException(numeroClient.toString() + " isn't in client list");
		}
	}
}
