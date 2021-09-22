package com.payments.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payments.beans.Bank;
import com.payments.beans.Message;

public interface MessageRepo extends JpaRepository<Message, String> {

}
