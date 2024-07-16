package com.banking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.entity.Account_Details;
import com.banking.entity.Bank_Staff;
import com.banking.entity.Customer;
import com.banking.entity.User_Master;
import com.banking.repository.AccountDetailsRepository;
import com.banking.repository.BankStaffRepo;
import com.banking.repository.BankUserRepo;
import com.banking.repository.BankdaoRepo;

import jakarta.validation.Valid;

@Service
public class BankService{
    @Autowired
     private BankdaoRepo bankrepo;
    @Autowired
    private BankUserRepo bankuser;
    
    @Autowired
    private AccountDetailsRepository accountdetailrepository;
   
    @Autowired
    private BankStaffRepo bankstaffrepo;
    
	public Customer addAccount(Customer customer) {
		Customer cu=bankrepo.save(customer);
		User_Master user=new User_Master(cu.getEmail(), cu.getPassword(), "Customer",cu);
		bankuser.save(user);
	    return cu;
		}
	
	public Bank_Staff StaffAccountAdd(Bank_Staff staff) {
		Bank_Staff bs=bankstaffrepo.save(staff);
		User_Master user=new User_Master(bs.getEmail(), "Pass@123", "Bank Staff",bs);
		bankuser.save(user);
	    return bs;
		}
	
	public boolean login(User_Master user) {
		System.out.println(user.getUsername());
   User_Master um=bankuser.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(um != null) {
			return true;
		}
		return false;
	}

	 
   
   
   
   

    public String Details(Account_Details Ad) {
       
       long customer_id=Ad.getCustomer_id();
       
       Optional<Customer> cu=bankrepo.findById(customer_id);
       System.out.println("cuuuuuuuu"+cu);
       if(cu != null) {
        long min = 100000000000L;
        long max = 999999999999L;
        Optional<Account_Details> ad1=accountdetailrepository.findById(customer_id);
        if(ad1!= null) {
        	Account_Details ad2=ad1.get();
        	String accounttype=ad2.getAcc_type();
        	if(!accounttype.equals(Ad.getAcc_type())){
        		 Random random =  new Random();
        	        long Acountrandom = min + ((long)(random.nextDouble()*(max-min)));
        	       
        	        Ad.setAcc_no(Acountrandom);
        	        accountdetailrepository.save(Ad);
        	        return "Account details added successfully";
        	}else {
        		 return "Account is already exist";
        	}
        }else {
        	 Random random =  new Random();
 	        long Acountrandom = min + ((long)(random.nextDouble()*(max-min)));
 	       
 	        Ad.setAcc_no(Acountrandom);
 	        accountdetailrepository.save(Ad);
        	return "added successfully";
        }
       
       }
       else {
    	   return "this customer is not prsent in customer table";
       }
       
       
       
       
       
       
    }
	


}
