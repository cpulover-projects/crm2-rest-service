package com.cpulover.springboot.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpulover.springboot.cruddemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> { // entity and primary key type
}
