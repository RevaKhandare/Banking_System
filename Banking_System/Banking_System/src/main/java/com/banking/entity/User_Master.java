package com.banking.entity;

import com.banking.validation.UserTypeValidation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class User_Master {	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long user_id;

@NotEmpty(message = "Email must not be null or empty")
@Email(message = "Not a valid email")
private String username;
@NotEmpty(message = "Password Should not empty")
@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$", message = "Password must have "
        + "    Min 1 uppercase letter."
        + "    Min 1 lowercase letter."
        + "    Min 1 special character."
        + "    Min 1 number."
        + "    Min 8 characters.")
private String password;
@NotEmpty
@UserTypeValidation
private String user_type;

@OneToOne
//@MapsId
private Customer customer;

@OneToOne
//@MapsId
private Bank_Staff bankstaff;


public long getUser_id() {
	return user_id;
}

public void setUser_id(long user_id) {
	this.user_id = user_id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUser_type() {
	return user_type;
}

public void setUser_type(String user_type) {
	this.user_type = user_type;
}

public Bank_Staff getBankstaff() {
	return bankstaff;
}

public void setBankstaff(Bank_Staff bankstaff) {
	this.bankstaff = bankstaff;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public User_Master(String username, String password, String user_type, Customer customer) {
	super();
	this.username = username;
	this.password = password;
	this.user_type = user_type;
	this.customer = customer;
	
	
}
public User_Master(String username, String password, String user_type, Bank_Staff bankstaff) {
	super();
	this.username = username;
	this.password = password;
	this.user_type = user_type;
	this.bankstaff = bankstaff;
	
}

public User_Master() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "User_Master [user_id=" + user_id + ", username=" + username + ", password=" + password + ", user_type="
			+ user_type  + "]";
}




}
