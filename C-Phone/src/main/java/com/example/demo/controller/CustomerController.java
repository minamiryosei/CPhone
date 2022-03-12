package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.from.CustomerRegistrationRequest;
import com.example.demo.service.CustomerRegistrationService;


@Controller
public class CustomerController {
    @Autowired
    CustomerRegistrationService customerService;
    
//    @GetMapping("/customer/create")
//    public String product(Model model) {
//    List<Products> product= customerService.findAll();
//    model.addAttribute("product", product);
//	return "product";
//    }
    
    
//    @RequestMapping(value = "/customer/create",method = RequestMethod.GET)
//    public String product(@RequestParam String product_name, Model model) {
//    List<Products> product= customerService.findAll();
//    model.addAttribute("product", product);
//	return "product";
//    }
    
    
    
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
    	customerRequest.setProducts(customerRequest.getProducts());
    	customerService.insert(customerRequest);
        return "S_CUSTOMER_COMP";
//        return "redirect:S_CUSTOMER_COMP";
    }
    
    /**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
    @RequestMapping("/customer/{id}")
    public String displayDetail(@ModelAttribute CustomerRegistrationRequest customerDetail, Model model) {
      return "S_DETAIL";
    }
    
    @GetMapping("/search")
	  public String displayList(Model model) {
	    List<Customer> customerlist = customerService.searchAll();
	    model.addAttribute("customerlist", customerlist);
	    return "S_CUSTOMER_LIST";
	}
    

    
    
    
    /**
     * ユーザー編集画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー編集画面
     */
//    @GetMapping("/user/{id}/edit")
//    public String displayEdit(@PathVariable Long id, Model model) {
//      User user = userService.findById(id);
//      UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
//      userUpdateRequest.setId(user.getId());
//      userUpdateRequest.setName(user.getName());
//      userUpdateRequest.setPhone(user.getPhone());
//      userUpdateRequest.setAddress(user.getAddress());
//      customer.setLastname(customerRequest.getLastname());
//  	customer.setFirstname(customerRequest.getFirstname());
//  	customer.setRadio(customerRequest.getRadio());
//  	customer.setPostcode(customerRequest.getPostcode());
//  	customer.setAddress1(customerRequest.getAddress1());
//  	customer.setAddress2(customerRequest.getAddress2());
//  	customer.setAddress3(customerRequest.getAddress3());
//  	customer.setPhonenumber(customerRequest.getPhonenumber());
//  	customer.setMail(customerRequest.getMail());
//  	customer.setProducts(customerRequest.getProducts());
//  	customer.setRemarks(customerRequest.getRemarks());
//  	customer.setMail(customerRequest.getMail());
//  	customer.setUser_id(customerRequest.getUser_id());
//      
//      model.addAttribute("userUpdateRequest", userUpdateRequest);
//      return "user/edit";
//    }
    
    
    
    
    
    
    
    
    
    
    
//    @Controller
//    public class DropdownController {
//
//      @RequestMapping("/dropdown")
//      public String demo(Model model) {
//
//        Map<String, String> colors = new LinkedHashMap<String, String>();
//
//        colors.put("001", "あか");
//        colors.put("002", "きいろ");
//        colors.put("003", "みどり");
//        colors.put("004", "オレンジ");
//
//        model.addAttribute("colors", colors);
//        model.addAttribute("colorCd", "004");
//
//        return "dropdown"; // テンプレートファイル名
//      }
    
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