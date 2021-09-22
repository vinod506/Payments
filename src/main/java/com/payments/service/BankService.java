package com.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.Bank;
import com.payments.beans.Customer;
import com.payments.repo.BankRepo;
import com.payments.repo.CustomerRepo;

@Service
public class BankService implements IBankService {
	@Autowired
	BankRepo crep;
	@Override
	public Bank findById(String bic)
	{
		Optional<Bank> c = crep.findById(bic);
		return c.get();
	}
}
