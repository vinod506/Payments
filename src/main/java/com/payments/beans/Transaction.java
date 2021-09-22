package com.payments.beans;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.data.jpa.repository.Query;

@Entity(name = "transaction_log")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int trans_id;
	@ManyToOne
	@Transient
	Customer customer;
	@JoinColumn(name="sender_id",referencedColumnName = "cust_id")
	long sender_id;
	long reciever_id;
	double amount;
	@ManyToOne
	@Transient
	Bank bank;
	@JoinColumn(name="reciever_bic",referencedColumnName = "bic")
	String reciever_bic;
	LocalDateTime time_stamp;
	String trans_status;
	@ManyToOne
	@Transient
	Message message;
	@JoinColumn(name="msg",referencedColumnName = "msg_code")
	String msg;
	String reciever_name;
	
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	public long getSender_id() {
		return sender_id;
	}
	public void setSender_id(long sender_id) {
		this.sender_id = sender_id;
	}
	public long getReciever_id() {
		return reciever_id;
	}
	public void setReciever_id(long reciever_id) {
		this.reciever_id = reciever_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReciever_bic() {
		return reciever_bic;
	}
	public void setReciever_bic(String reciever_bic) {
		this.reciever_bic = reciever_bic;
	}
	public LocalDateTime getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getTrans_status() {
		return trans_status;
	}
	public void setTrans_status(String trans_status) {
		this.trans_status = trans_status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getReciever_name() {
		return reciever_name;
	}
	public void setReciever_name(String reciever_name) {
		this.reciever_name = reciever_name;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int trans_id, long sender_id, long reciever_id, double amount, String reciever_bic,
			LocalDateTime time_stamp, String trans_status, String msg, String reciever_name) {
		super();
		this.trans_id = trans_id;
		this.sender_id = sender_id;
		this.reciever_id = reciever_id;
		this.amount = amount;
		this.reciever_bic = reciever_bic;
		this.time_stamp = time_stamp;
		this.trans_status = trans_status;
		this.msg = msg;
		this.reciever_name=reciever_name;
	}
	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", sender_id=" + sender_id + ", reciever_id=" + reciever_id
				+ ", amount=" + amount + ", reciever_bic=" + reciever_bic + ", time_stamp=" + time_stamp
				+ ", trans_status=" + trans_status + ", msg=" + msg + "]";
	}
	
}
