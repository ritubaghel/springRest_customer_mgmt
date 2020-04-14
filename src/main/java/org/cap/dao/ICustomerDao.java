package org.cap.dao;

import org.cap.entities.Customer;

import java.util.List;

public interface ICustomerDao {

	Customer findById(int id);

	Customer save(Customer user);

    List<Customer> fetchAll();

    boolean remove(int id);
}
