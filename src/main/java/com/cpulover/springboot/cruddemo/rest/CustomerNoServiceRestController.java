package com.cpulover.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpulover.springboot.cruddemo.entity.Customer;
import com.cpulover.springboot.cruddemo.repository.CustomerRepository;

@RestController
@RequestMapping("/api2")
public class CustomerNoServiceRestController {

	@Autowired
	private CustomerRepository customerRepository; // inject by field

	// expose "/customers" and return list of customers
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	// add mapping for GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getEmployee(@PathVariable int customerId) {
//		Customer theCustomer = customerRepository.findById(customerId);
//		if (theCustomer == null) {
//			throw new RuntimeException("Customer id not found - " + customerId);
//		}
//		return theCustomer;

//		return customerRepository.findById(customerId).orElseThrow(IllegalArgumentException::new);
	    return customerRepository.findById(customerId).get();
	}

	// add mapping for POST /customers - add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theCustomer.setId(0);
		customerRepository.save(theCustomer);
		return theCustomer;
	}

	// add mapping for PUT /customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerRepository.save(theCustomer);
		return theCustomer;
	}

	// add mapping for DELETE /customers/{customerId} - delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
//		Customer tempCustomer = customerRepository.findById(customerId);
//		// throw exception if null
//		if (tempCustomer == null) {
//			throw new RuntimeException("Customer id not found - " + customerId);
//		}
//		customerRepository.deleteById(customerId);
//		return "Deleted customer id - " + customerId;

		customerRepository.findById(customerId).orElseThrow(IllegalArgumentException::new);
		customerRepository.deleteById(customerId);
		return "Deleted customer id - " + customerId;

	}

}
