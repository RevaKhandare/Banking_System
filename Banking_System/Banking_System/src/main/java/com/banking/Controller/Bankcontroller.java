package com.banking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.Service.BankService;
import com.banking.entity.Account_Details;
import com.banking.entity.Bank_Staff;
import com.banking.entity.Customer;
import com.banking.entity.User_Master;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bank")
public class Bankcontroller {
	@Autowired
	private BankService bankservice;

	@PostMapping("/addcustomer")
	public String addAccountCustomer(@Valid @RequestBody Customer customer) {
	
			bankservice.addAccount(customer);
			return "Registration is successful";
		
	}
	@PostMapping("/addstaff")
	public String addAccountstaff(@Valid @RequestBody Bank_Staff bankstaff) {
	
			bankservice.StaffAccountAdd(bankstaff);
			return "Registration is successful";
		
	}

	@PostMapping("/login")
	public String login(@RequestBody User_Master user) {
		if (bankservice.login(user)) {
			return "Login is successful";
		} else {
			return "Username password not present in the database";
		}

	}
	
	  @PostMapping(value="/AccountDetail", consumes="application/json")
       public String newcustomer(@Valid @RequestBody Account_Details Ad) {
	        return bankservice.Details(Ad);
	    }

}
