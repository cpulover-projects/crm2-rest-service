package com.cpulover.springboot.cruddemo.service;

import java.util.List;

import com.cpulover.springboot.cruddemo.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();	
	public Customer findById(int theId);
	public void save(Customer theCustomer);	
	public void deleteById(int theId);
}
