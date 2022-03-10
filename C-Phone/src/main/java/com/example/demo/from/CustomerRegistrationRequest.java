package com.example.demo.from;

import java.io.Serializable;

import lombok.Data;


@Data

public class CustomerRegistrationRequest implements Serializable {
	
	private Integer user_id;

    private String lastname;


	private String firstname;
	
	private Integer radio;


	private String phonenumber;
	

	private String postcode;
	

	private String mail;
	

	private String address1;
	

	private String address2;
	

	private String address3;
	

	private Integer products;
	
	
	private String remarks;
}