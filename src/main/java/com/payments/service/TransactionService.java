package com.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.Message;
import com.payments.beans.Transaction;
import com.payments.repo.MessageRepo;
import com.payments.repo.TransactionRepo;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	TransactionRepo crep;
	@Override
	public Transaction findById(int trans_id)
	{
		//Optional<Transaction> c = crep.findById(trans_id);
		//return c.get();
		return crep.findById(trans_id).get();
		
	}
	
	@Override
	public Transaction addTransaction(Transaction transaction)
	{
		return crep.save(transaction);
	}
	
	@Override
	public double findtotbalance(long id)
	{
		return crep.getamo(id);
	}
	
//	@Override
//	public double getAmount(long t)
//	{
//		Optional<Transaction> c = crep.findById(t);
//		return c;
//	}
}
