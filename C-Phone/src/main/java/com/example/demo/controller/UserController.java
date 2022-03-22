package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserDetailsServiceImpl;


@Controller

public class UserController {
	@Autowired
	UserDetailsServiceImpl UserDetailsServiceImpl;

//	@Autowired
//    PasswordEncoder passwordEncoder;


	@GetMapping("/login")
	public String login(){
		return "S_LOGIN";
	}
	
	@GetMapping("/")
	public String top(){
		return "S_TOP";
	}
	
//	@GetMapping("/")
//	public String top(){
//		return "S_TOP";
//	}
	




}