package com.payments.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.payments.beans.Message;
import com.payments.beans.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	
	@Query("select SUM(amount) from transaction_log WHERE sender_id=?1")
	public double getamo(long id);
}
