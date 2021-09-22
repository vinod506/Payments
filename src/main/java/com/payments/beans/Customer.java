package com.payments.beans;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.payments.enums.OD_Enum;

@Entity(name = "customer_details")
public class Customer {
	@Id
	long cust_id;
	String cust_name;
	double balance;
	@Enumerated(EnumType.STRING)
	OD_Enum over_draft;
	public long getCust_id() {
		return cust_id;
	}
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public OD_Enum getOver_draft() {
		return over_draft;
	}
	public void setOver_draft(OD_Enum over_draft) {
		this.over_draft = over_draft;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", balance=" + balance + ", over_draft="
				+ over_draft + "]";
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(long cust_id, String cust_name, double balance, OD_Enum over_draft) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.balance = balance;
		this.over_draft = over_draft;
	}
	
}
