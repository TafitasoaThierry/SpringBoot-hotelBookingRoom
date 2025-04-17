package com.hotel.service;

import com.hotel.model.Customer;

import com.hotel.repository.CustomerRepository;

import jakarta.el.ELException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer newCustomer) {
        return this.customerRepository.save(newCustomer);
    }

    public List<Customer> getCustomerList() {
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByNumber(Long customerNumber) {
        return this.customerRepository.findById(customerNumber);
    }

    /*
    public Optional<Customer> getCustomeryPhone(String phone) {
        return this.customerRepository.findById(phone);
    }
    */

    public String deleteCustomer(Long customerNumber) {
        if(this.customerRepository.findById(customerNumber).isPresent()) {
            this.customerRepository.deleteById(customerNumber);
            return "customer deleted";
        }else {
            return customerNumber.toString() + " isn't in customer list";
        }
    }

    public Customer updateCustomer(Long customerNumber, Customer newCustomerInfo) {
        if(this.customerRepository.findById(customerNumber).isPresent()) {
            Customer customerInfo = this.customerRepository.findById(customerNumber).get();
            customerInfo.setName(newCustomerInfo.getName());
            customerInfo.setSurName(newCustomerInfo.getSurName());
            customerInfo.setEmail(newCustomerInfo.getEmail());
            customerInfo.setPhone(newCustomerInfo.getPhone());
            customerInfo.setPassWord(newCustomerInfo.getPassWord());

            return this.customerRepository.save(customerInfo);
        }else {
            throw new ELException(customerNumber.toString() + " isn't in customer list");
        }
    }
}
