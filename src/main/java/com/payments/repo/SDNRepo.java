package com.payments.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payments.beans.SDN_list;
import com.payments.beans.Transaction;

public interface SDNRepo extends JpaRepository<SDN_list, String>{

}
