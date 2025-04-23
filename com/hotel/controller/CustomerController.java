package com.hotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.model.Customer;
import com.hotel.service.CustomerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel/customer")
public class CustomerController {
    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> customer(@RequestBody Customer newCustomer) {
        return ResponseEntity.ok(this.customerService.addCustomer(newCustomer));
    }

    @GetMapping("/getCustomerList")
    public ResponseEntity<List<Customer>> getCustomerList() {
        return ResponseEntity.ok(this.customerService.getCustomerList());
    }

    @GetMapping("/getCustomerByNumber/{customerNumber}")
    public ResponseEntity<Optional<Customer>> getCustomerByNumber(@PathVariable Long customerNumber) {
        return ResponseEntity.ok(this.customerService.getCustomerByNumber(customerNumber));
    }

    @DeleteMapping("/deleteCustomer/{customerNumber}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long customerNumber) {
        return ResponseEntity.ok(this.customerService.deleteCustomer(customerNumber));
    }

    @PutMapping("/updateCustomer/{customerNumber}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerNumber, @RequestBody Customer newCustomerInfo) {
        return ResponseEntity.ok(this.customerService.updateCustomer(customerNumber, newCustomerInfo));
    }
}
