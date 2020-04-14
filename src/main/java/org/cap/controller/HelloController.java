package org.cap.controller;

import org.cap.entities.Customer;
import org.cap.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ICustomerService customerService;


    @GetMapping("/find")
    public ModelAndView findPage() {
        return new ModelAndView("findemployee");
    }


    @GetMapping("/processfindcust")
    public ModelAndView customerDetails(@RequestParam("custid")int custId) {
        System.out.println("inside customerDetails,id="+custId);
        Customer customer= customerService.findById(custId);
        return new ModelAndView("customerdetails", "customer", customer);
    }


    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("customerregister");// only provide view name
    }

    @GetMapping("/processregister")
    public ModelAndView registerCustomer(@RequestParam("custname") String custName) {
        Customer customer=new Customer();
        customer.setCustName(custName);
        customer=customerService.save(customer);
        return new ModelAndView("customerdetails",  "customer", customer);
    }

    @GetMapping("/displayall")
    public ModelAndView displayAll(){
        List<Customer> customers= customerService.fetchAll();
        ModelAndView modelAndView=new ModelAndView("listcustomers","customers",customers);
        return modelAndView;
    }



}
