package org.cap.controller;

import org.cap.dto.CustomerDto;
import org.cap.entities.Customer;
import org.cap.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService service;

    @GetMapping("/customers/find/{custid}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("custid") int custid) {
        Customer customer = service.findById(custid);
        if(customer==null){
            ResponseEntity<Customer> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return response;
        }
        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
        return response;
    }

    @PostMapping("/customers/add")
    public ResponseEntity<Customer> addEmployee(@RequestBody CustomerDto dto) {
        Customer customer = convert(dto);
        customer = service.save(customer);
        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
        return response;
    }

    Customer convert(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setCustName(dto.getCustName());
        return customer;
    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchAll() {
        List<Customer> customers = service.fetchAll();
        ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/customers/delete/{custid}")
    public ResponseEntity<Boolean>deleteEmployee(@PathVariable int custid){
       boolean result= service.remove(custid);
       ResponseEntity<Boolean>response=new ResponseEntity<>(result, HttpStatus.OK);
       return response;
    }

    @PutMapping("/customers/update/{custid}")
    public ResponseEntity<Customer>updateEmployee(@RequestBody CustomerDto dto ,@PathVariable("custid")int custid){
        Customer customer=convert(dto);
        customer.setCustId(custid);
        customer=service.save(customer);
        ResponseEntity<Customer>response=new ResponseEntity<>(customer,HttpStatus.OK);
        return response;
    }

}
