package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CustomerUpdateRequest;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Products;
import com.example.demo.from.CustomerRegistrationRequest;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductsRrepository;

@Service
@Transactional
public class CustomerRegistrationService {
	@Autowired
    CustomerRepository customerRepository;
	
	@Autowired
	ProductsRrepository productsRepository;
	
	/**
	 * ユーザー情報 全検索
	 * @return 検索結果
	 */
    public List<Customer> searchAll() {
        return customerRepository.findAll();
    }
    
    public List<Products> findAll() {
        return productsRepository.findAll();
    }
    
    public void insert(CustomerRegistrationRequest customerRequest) {
    	System.out.println(customerRequest);

    	customerRepository.save(CreateCustomer(customerRequest));
    	
    }

    /**
     * ユーザー情報 主キー検索
     * @return 検索結果
     */
    public Customer findById(Integer customerId) {
      return customerRepository.findById(customerId).get();
    }
    
    public void update(CustomerRegistrationRequest customerRequest) {
        customerRepository.save(CreateCustomer(null));
    }
    
    /**
     * ユーザー情報 更新
     * @param user ユーザー情報
     */
    public void update(CustomerUpdateRequest customerUpdateRequest) {
    	Customer customer = findById(customerUpdateRequest.getId());
    	customer.setLastname(customerUpdateRequest.getLastname());
	  	customer.setFirstname(customerUpdateRequest.getFirstname());
	  	customer.setRadio(customerUpdateRequest.getRadio());
	  	customer.setPostcode(customerUpdateRequest.getPostcode());
	  	customer.setAddress1(customerUpdateRequest.getAddress1());
	  	customer.setAddress2(customerUpdateRequest.getAddress2());
	  	customer.setAddress3(customerUpdateRequest.getAddress3());
	  	customer.setPhonenumber(customerUpdateRequest.getPhonenumber());
	  	customer.setMail(customerUpdateRequest.getMail());
	  	customer.setProducts(customerUpdateRequest.getProducts());
	  	customer.setRemarks(customerUpdateRequest.getRemarks());
	  	customer.setMail(customerUpdateRequest.getMail());
	  	customer.setUser_id(customerUpdateRequest.getUser_id());
      customerRepository.save(customer);
    }

    /**
     * ユーザー情報 物理削除
     * @param id ユーザーID
     */
    public void delete(Integer id) {
      Customer customer = findById(id);
      customerRepository.delete(customer);
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