package com.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.banking.entity.Customer;

public interface BankdaoRepo extends CrudRepository<Customer,Long> {
	
}
