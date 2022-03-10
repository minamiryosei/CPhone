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

    
    public void insert(CustomerRegistrationRequest customerRequest) {
    	System.out.println(customerRequest);

    	customerRepository.save(CreateCustomer(customerRequest));
    	
    }

    
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    
    public Optional<Customer> selectById(Integer id) {
        return customerRepository.findById(id);
    }
    private Customer CreateCustomer(CustomerRegistrationRequest customerRequest) {
        
    	Customer customer = new Customer();
    	
    	customer.setLastname(customerRequest.getLastname());
    	customer.setFirstname(customerRequest.getFirstname());
    	customer.setRadio(customerRequest.getRadio());
    	customer.setPostcode(customerRequest.getPostcode());
    	customer.setAddress1(customerRequest.getAddress1());
    	customer.setAddress2(customerRequest.getAddress2());
    	customer.setAddress3(customerRequest.getAddress3());
    	customer.setPhonenumber(customerRequest.getPhonenumber());
    	customer.setMail(customerRequest.getMail());
    	customer.setProducts(customerRequest.getProducts());
    	customer.setRemarks(customerRequest.getRemarks());
    	customer.setMail(customerRequest.getMail());
    	customer.setUser_id(customerRequest.getUser_id());
    	
        return customer;
    }
}
