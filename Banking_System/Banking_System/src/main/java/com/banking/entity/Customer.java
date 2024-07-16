package com.banking.entity;

import java.sql.Date;

import org.hibernate.validator.constraints.Range;

import com.banking.validation.ValidateDob;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customer_id;
	
	@NotEmpty(message = "Name must not be null or empty")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Employee name must be in capital case .")
    private String fname;
    @NotEmpty(message = "Name must not be null or empty")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Employee name must be in capital case .")
    private String lname;
    @NotNull
    @ValidateDob
    private Date dob;
    @NotEmpty(message = "Email must not be null or empty")
    @Email(message = "Not a valid email")
    private String email;
    private String address;
    @NotNull(message = "Phone nuber must not be null or empty")
    @Range(min = 1000000000L, max = 9999999999L , message = "Phone number should be 10 digits and should not start with zero.")
    private long phone_no;
    @NotEmpty(message = "Password Should not empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$", message = "Password must have "
            + "    Min 1 uppercase letter."
            + "    Min 1 lowercase letter."
            + "    Min 1 special character."
            + "    Min 1 number."
            + "    Min 8 characters.")
	private String password;
	
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
	private User_Master usermaster;

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User_Master getUsermaster() {
		return usermaster;
	}

	public void setUsermaster(User_Master usermaster) {
		this.usermaster = usermaster;
	}

	public Customer(long customer_id, String fname, String lname, Date dob, String email, String address, long phone_no,
			String password, User_Master usermaster) {
		super();
		this.customer_id = customer_id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.phone_no = phone_no;
		this.password = password;
		this.usermaster = usermaster;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", email=" + email + ", address=" + address + ", phone_no=" + phone_no + ", password=" + password
				+ ", usermaster=" + usermaster + "]";
	}
	

}
