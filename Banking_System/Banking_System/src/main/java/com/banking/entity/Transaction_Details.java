package com.banking.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction_Details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long transaction_id;
private String transaction_type;
private long amount;
private Date transaction_date;
public long getTransaction_id() {
	return transaction_id;
}
public void setTransaction_id(long transaction_id) {
	this.transaction_id = transaction_id;
}
public String getTransaction_type() {
	return transaction_type;
}
public void setTransaction_type(String transaction_type) {
	this.transaction_type = transaction_type;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
public Date getTransaction_date() {
	return transaction_date;
}
public void setTransaction_date(Date transaction_date) {
	this.transaction_date = transaction_date;
}
public Transaction_Details(long transaction_id, String transaction_type, long amount, Date transaction_date) {
	super();
	this.transaction_id = transaction_id;
	this.transaction_type = transaction_type;
	this.amount = amount;
	this.transaction_date = transaction_date;
}
public Transaction_Details() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Transaction_Details [transaction_id=" + transaction_id + ", transaction_type=" + transaction_type
			+ ", amount=" + amount + ", transaction_date=" + transaction_date + "]";
}

}
