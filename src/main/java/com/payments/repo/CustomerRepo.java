package com.payments.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payments.beans.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
