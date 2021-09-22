package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bank_details")
public class Bank {
	@Id
	String bic;
	String b_name;
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", b_name=" + b_name + "]";
	}
	public Bank(String bic, String b_name) {
		super();
		this.bic = bic;
		this.b_name = b_name;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
