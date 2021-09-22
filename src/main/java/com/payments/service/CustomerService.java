package com.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.payments.beans.Customer;
import com.payments.repo.CustomerRepo;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	CustomerRepo crep;
	@Override
	public Customer findById(long id)
	{
		Optional<Customer> c = crep.findById(id);
		return c.get();
	}
	@Override
	public double findBalance(long id)
	{
		Optional<Customer> c = crep.findById(id);
		Customer c1= c.get();
		return c1.getBalance();
	}
}
