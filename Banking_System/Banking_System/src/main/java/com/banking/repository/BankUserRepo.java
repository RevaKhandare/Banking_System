package com.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.banking.entity.User_Master;

public interface BankUserRepo extends JpaRepository<User_Master,Long> {

	User_Master findByUsernameAndPassword(String username, String password);
	
	  
//	 findByUsernameAndPassword( String username,String password);
}
