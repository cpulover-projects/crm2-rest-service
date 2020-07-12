package com.cpulover.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpulover.springboot.cruddemo.entity.Customer;
import com.cpulover.springboot.cruddemo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository theEmployeeRepository) {
		customerRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
//		Optional<Customer> result = customerRepository.findById(theId);
//		
//		Customer theCustomer = null;
//		
//		if (result.isPresent()) {
//			theCustomer = result.get();
//		}
//		else {
//			throw new RuntimeException("Did not find customer id - " + theId);
//		}
//		
//		return theCustomer;
		return customerRepository.findById(theId).get();
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}
}






