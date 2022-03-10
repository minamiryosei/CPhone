package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.from.CustomerRegistrationRequest;
import com.example.demo.service.CustomerRegistrationService;


@Controller
public class CustomerController {
    @Autowired
    CustomerRegistrationService customerService;
    
    @RequestMapping(value = "/customer/create", method = RequestMethod.GET)
    public String displayAdd(Model model) {
        model.addAttribute("customerRequest", new CustomerRegistrationRequest());
        return "S_CUSTOMER_I";
        
    }

       
    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public String create(@ModelAttribute CustomerRegistrationRequest customerRequest, Model model ,@AuthenticationPrincipal User user) {
        // ユーザー情報の登録
    	customerRequest.setUser_id(user.getId());
    	customerService.insert(customerRequest);
        return "S_CUSTOMER_COMP";
//        return "redirect:S_CUSTOMER_COMP";
    }
}
        
//    @GetMapping("/customer/create")
//    public String displayAdd() {
////        model.addAttribute("customerRequest", new CustomerRegistrationRequest());
//        return "S_CUSTOMER_I";
//       
//    }
//    
//       
//    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
//    public String create(@ModelAttribute CustomerRegistrationRequest customerRequest, Model model) {
//        // ユーザー情報の登録
//    
////    	customerService.insert(customerRequest);
//        return "redirect:S_CUSTOMER_LIST";
//    }
//}
//
//CustomerRegistrationService customerService;





//

//
//    @GetMapping
//    String list(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "list";
//    }
//
//    @GetMapping("create")
//    String create(@ModelAttribute CustomerForm customerForm) {
//        return "create";
//    }
//
//    //ポイント1
//    @PostMapping("create")
//    String regist(@ModelAttribute CustomerForm customerForm, Object customerService) {
//        Customer customer = new Customer();
//        //ポイント2
//        BeanUtils.copyProperties(customerForm, customer);
//
//       
//        ((Object) customerService).insert(customer); 
//
//        //ポイント4
//        return "redirect:/";
//    }
//}
//



//@Controller
//public class CustomerController {
//    @Autowired
//    CustomerService customerService;
//
//    @GetMapping
//    String list(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "list";
//    }
//
//    //ポイント1
//    @GetMapping("create")
//    //ポイント2
//    String create(@ModelAttribute CustomerForm customerForm) {
//        return "create";
//    }
//}
//
//
//
//
//
//
//
////@Controller
////public class CustomerController {
////    @Autowired
////    CustomerRegistrationService CustomerRegistrationService;
////
////    @GetMapping
////    String list(Model model) {
////        List<Customer> customers = CustomerRegistrationService.findAll();
////        model.addAttribute("customers", customers);
////        return "list";
////    }
////
////    //ポイント1
////    @GetMapping("/customer")
////    //ポイント2
////    String customer(@ModelAttribute CustomerForm customerForm) {
////        return "S_CUSTOMER_I.html";
////    }
////    
////
////    //ポイント1
//    @PostMapping("customer")
//    String regist(@ModelAttribute CustomerForm customerForm) {
//    	CustomerController customer = new CustomerController();
//        //ポイント2
//        BeanUtils.copyProperties(customerForm, customer);
//
//        //ポイント3
//        CustomerRegistrationService.insert(customer);
//
//        //ポイント4
//        return "redirect:/";
//    }
////
////    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
////    public String create(@ModelAttribute UserRequest userRequest, Model model) {
////        // ユーザー情報の登録
////        userService.create(userRequest);
////        return "redirect:/user/list";
////    }
////	
////
////}
////
////
////@Controller
////public class UserController {
////    /**
////     * ユーザー情報 Service
////     */
////    @Autowired
////    UserService userService;
////    /**
////     * ユーザー情報一覧画面を表示
////     * @param model Model
////     * @return ユーザー情報一覧画面
////     */
////    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
////    public String displayList(Model model) {
////        List<User> userlist = userService.searchAll();
////        model.addAttribute("userlist", userlist);
////        return "user/list";
////    }
////    /**
////     * ユーザー新規登録画面を表示
////     * @param model Model
////     * @return ユーザー情報一覧画面
////     */
////    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
////    public String displayAdd(Model model) {
////        model.addAttribute("userRequest", new UserRequest());
////        return "user/add";
////    }
////    /**
////     * ユーザー新規登録
////     * @param userRequest リクエストデータ
////     * @param model Model
////     * @return ユーザー情報一覧画面
////     */
////    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
////    public String create(@ModelAttribute UserRequest userRequest, Model model) {
////        // ユーザー情報の登録
////        userService.create(userRequest);
////        return "redirect:/user/list";
////    }
//}