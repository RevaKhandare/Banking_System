
package com.banking.entity;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Account_Details {
    @Id
   
    private long customer_id;
   
    private long acc_no;
    private String acc_type;
    @Range(min = 2000,message="Amount should be greaterb than 2000")
    private double balance;
    public Account_Details() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Account_Details(long customer_id, long acc_no, String acc_type, double balance) {
        super();
        this.customer_id = customer_id;
        this.acc_no = acc_no;
        this.acc_type = acc_type;
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account_Details [customer_id=" + customer_id + ", acc_no=" + acc_no + ", acc_type=" + acc_type
                + ", balance=" + balance + "]";
    }
    public long getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
    public long getAcc_no() {
        return acc_no;
    }
    public void setAcc_no(long acc_no) {
        this.acc_no = acc_no;
    }
    public String getAcc_type() {
        return acc_type;
    }
    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
     
   

}



