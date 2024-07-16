package com.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.banking.entity.Account_Details;
import com.banking.entity.Customer;

public interface AccountDetailsRepository extends CrudRepository<Account_Details,Long>{
}
