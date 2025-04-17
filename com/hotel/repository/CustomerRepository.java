package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}