package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sdn")
public class SDN_list {
	@Id
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SDN_list [name=" + name + "]";
	}

	public SDN_list(String name) {
		super();
		this.name = name;
	}

	public SDN_list() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
