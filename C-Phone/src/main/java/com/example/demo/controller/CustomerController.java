package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.CustomerUpdateRequest;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.from.CustomerRegistrationRequest;
import com.example.demo.service.CustomerRegistrationService;


@Controller
public class CustomerController {
    @Autowired
    CustomerRegistrationService customerService;
    
    @GetMapping("/customer/create")
    public String displayAdd(Model model) {
        model.addAttribute("customerRequest", new CustomerRegistrationRequest());

        List<Products> product= customerService.findAll();
        model.addAttribute("product", product);
//    	return "product";
      return "S_CUSTOMER_I";
        }
    
    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public String top(Model model) {
        return "S_TOP";
    }
        
    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public String create(@ModelAttribute CustomerRegistrationRequest customerRequest, Model model ,@AuthenticationPrincipal User user) {
        // ユーザー情報の登録
    	customerRequest.setUser_id(user.getId());
    	customerService.insert(customerRequest);
        return "S_CUSTOMER_COMP";
        
    }

	@GetMapping("/search")
	  public String displayList(Model model) {
	    List<Customer> customerlist = customerService.searchAll();
	    model.addAttribute("customerlist", customerlist);
	    return "S_CUSTOMER_LIST";
	}

    
	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
    @GetMapping("/S_DETAIL/{id}")
    public String displayDetail(@PathVariable Integer id, Model model) {
    	Customer customer = customerService.findById(id);
        model.addAttribute("customerData", customer);
        List<Products> product= customerService.findAll();
        model.addAttribute("product", product);
      return "S_DETAIL";
    }
    

    /**
     * ユーザー編集画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー編集画面
     */
    @GetMapping("/S_EDIT_I/{id}")
    public String displayEdit(@PathVariable Integer id, Model model) {
      Customer customer = customerService.findById(id);
      CustomerUpdateRequest customerUpdateRequest = new CustomerUpdateRequest();
      customerUpdateRequest.setId(customer.getCustomerId());
      customerUpdateRequest.setLastname(customer.getLastname());
      customerUpdateRequest.setFirstname(customer.getFirstname());
      customerUpdateRequest.setRadio(customer.getRadio());
      customerUpdateRequest.setPostcode(customer.getPostcode());
      customerUpdateRequest.setAddress1(customer.getAddress1());
      customerUpdateRequest.setAddress2(customer.getAddress2());
      customerUpdateRequest.setAddress3(customer.getAddress3());
      customerUpdateRequest.setPhonenumber(customer.getPhonenumber());
      customerUpdateRequest.setMail(customer.getMail());
      customerUpdateRequest.setProducts(customer.getProducts());
      customerUpdateRequest.setRemarks(customer.getRemarks());
      customerUpdateRequest.setUser_id(customer.getUser_id());
      model.addAttribute("customerUpdateRequest", customerUpdateRequest);
      List<Products> product= customerService.findAll();
      model.addAttribute("product", product);
      return "S_EDIT_I";
    }
    /**
     * ユーザー更新
     * @param customerRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute CustomerUpdateRequest customerUpdateRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "/S_DETAIL/{id}";
      }
      // ユーザー情報の更新
      customerService.update(customerUpdateRequest);
      return String.format("redirect:/", customerUpdateRequest.getId());
    }
 
    /**
     * ユーザー情報削除
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/S_DETAIL/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
      // ユーザー情報の削除
      customerService.delete(id);
      // 顧客一覧へ遷移
      return "S_CANCEL_COMP";
    }
    
    
    
    @GetMapping("/customer/call")
	public String call(Model model){
		return "S_CUSTOMER_CALL";
	}
}