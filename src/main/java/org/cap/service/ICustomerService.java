package org.cap.service;

import org.cap.entities.Customer;

import java.util.List;

public interface ICustomerService {

    Customer findById(int custid);

    Customer save(Customer user);


    List<Customer> fetchAll();

    boolean remove(int custid);
}
