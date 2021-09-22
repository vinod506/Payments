package com.payments.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payments.beans.Bank;

public interface BankRepo extends JpaRepository<Bank, String> {

}

