package com.payments.service;

import java.util.List;

import com.payments.beans.Message;

public interface IMessageService {

	Message findById(String msg_code);

	List<Message> findAll();

}