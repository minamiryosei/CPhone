package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;
import com.example.demo.from.CustomerRegistrationRequest;
import com.example.demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerRegistrationService {
	@Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //ポイント①
    public void insert(CustomerRegistrationRequest customerRequest) {

    	customerRepository.save(CreateCustomer(customerRequest));
    }

    //ポイント②
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    //ポイント③
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    //ポイント④
    public Optional<Customer> selectById(Integer id) {
        return customerRepository.findById(id);
    }
    private Customer CreateCustomer(CustomerRegistrationRequest customerRequest) {
        
    	Customer customer = new Customer();
    	customer.setLastName(customerRequest.getLastname());
    	customer.setFirstName(customerRequest.getFirstname());
    	
//    	customer.setAddress(customerRequest.getAddress());
//    	customer.setPhone(customerRequest.getPhone());
    	
        return customer;
    }
}
