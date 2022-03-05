//package com.example.demo.controller;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.entity.Customer;
//import com.example.demo.service.CustomerRegistrationService;
//
//@Controller
//public class CustomerController {
//    @Autowired
//    CustomerRegistrationService CustomerRegistrationService;
//
////    @GetMapping
////    String list(Model model) {
////        List<Customer> customers = CustomerRegistrationService.findAll();
////        model.addAttribute("customers", customers);
////        return "list";
////    }
//
//    //ポイント1
//    @GetMapping("/customer")
//    //ポイント2
//    String customer(@ModelAttribute CustomerForm customerForm) {
//        return "S_CUSTOMER_I.html";
//    }
//    
//
////    //ポイント1
////    @PostMapping("customer")
////    String regist(@ModelAttribute CustomerForm customerForm) {
////        Customer customer = new Customer();
////        //ポイント2
////        BeanUtils.copyProperties(customerForm, customer);
////
////        //ポイント3
////        CustomerRegistrationService.insert(customer);
////
////        //ポイント4
////        return "redirect:/";
//    }
//
//
//	
//
//}