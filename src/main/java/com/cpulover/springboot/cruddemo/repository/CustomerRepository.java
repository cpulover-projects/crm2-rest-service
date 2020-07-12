package com.cpulover.springboot.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cpulover.springboot.cruddemo.entity.Customer;

@RepositoryRestResource(path="customers") //Specify plural name/path: local:8080/customers
public interface CustomerRepository extends JpaRepository<Customer, Integer> { // entity and primary key type
}
