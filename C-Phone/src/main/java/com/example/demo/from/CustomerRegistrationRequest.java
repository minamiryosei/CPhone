package com.example.demo.from;

import java.io.Serializable;

import lombok.Data;


@Data

public class CustomerRegistrationRequest implements Serializable {

    private String lastname;


	private String firstname;


	private String phonenumber;
	

	private String postcode;
	

	private String mail;
	

	private int abc;


	private String address1;
	

	private String address2;
	

	private String address3;
	

	private int product;
}