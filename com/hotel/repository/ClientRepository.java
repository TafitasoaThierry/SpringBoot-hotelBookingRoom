package com.hotel.repository;

import com.hotel.model.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client> findAllByTel(String tel);
    public List<Client> findAllByEmail(String email);
}
