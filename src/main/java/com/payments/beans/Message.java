package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "msg_info")
public class Message {
	@Id
	String msg_code;
	String instruction;
	public String getMsg_code() {
		return msg_code;
	}
	public void setMsg_code(String msg_code) {
		this.msg_code = msg_code;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Message [msg_code=" + msg_code + ", instruction=" + instruction + "]";
	}
	public Message(String msg_code, String instruction) {
		super();
		this.msg_code = msg_code;
		this.instruction = instruction;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
