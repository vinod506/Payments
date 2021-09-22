package com.payments.service;

import com.payments.beans.Transaction;

public interface ITransactionService {

	Transaction findById(int trans_id);

	Transaction addTransaction(Transaction transaction);

	double findtotbalance(long id);

}