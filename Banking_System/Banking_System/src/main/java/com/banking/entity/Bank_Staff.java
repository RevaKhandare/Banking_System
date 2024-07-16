package com.banking.entity;

import java.sql.Date;

import org.hibernate.validator.constraints.Range;

import com.banking.validation.ValidateDob;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Entity
public class Bank_Staff {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long Staff_id;
	    @NotEmpty(message = "Name must not be null or empty")
	    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Employee name must be in capital case .")
	    private String fname;
	    @NotEmpty(message = "Name must not be null or empty")
	    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Employee name must be in capital case .")
	    private String lname;
	    @NotNull
	    @ValidateDob
	    private Date dob;
	    @NotEmpty(message = "Gender must not be null or empty")
	    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Gender must be in capital case .")
	    private String gender;
	    @NotEmpty(message = "Email must not be null or empty")
	    @Email(message = "Not a valid email")
	    private String email;
	    private String address;
	    @NotNull(message = "Phone nuber must not be null or empty")
	    @Range(min = 1000000000L, max = 9999999999L , message = "Phone number should be 10 digits and should not start with zero.")
	    private long phone_no;
	    @NotNull
	    private Date joining_Date;
	    
	    @OneToOne(mappedBy="bankstaff",cascade=CascadeType.ALL)
		private User_Master usermaster;

	
	public long getStaff_id() {
		return Staff_id;
	}

	public void setStaff_id(long staff_id) {
		Staff_id = staff_id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getJoining_Date() {
		return joining_Date;
	}

	public void setJoining_Date(Date joining_Date) {
		this.joining_Date = joining_Date;
	}


	public Bank_Staff(long staff_id, String fname, String lname, Date dob, String gender, String email, String address,
			long phone_no, Date joining_Date, User_Master usermaster) {
		super();
		Staff_id = staff_id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phone_no = phone_no;
		this.joining_Date = joining_Date;
	}

	@Override
	public String toString() {
		return "Bank_Staff [Staff_id=" + Staff_id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", address=" + address + ", phone_no=" + phone_no
				+ ", joining_Date=" + joining_Date +  "]";
	}

	public Bank_Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
}
