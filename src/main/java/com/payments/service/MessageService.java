package com.payments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.Message;
import com.payments.repo.MessageRepo;


@Service
public class MessageService implements IMessageService{
	@Autowired
	MessageRepo crep;
	@Override
	public Message findById(String msg_code)
	{
		Optional<Message> c = crep.findById(msg_code);
		return c.get();
	}
	@Override
	public List<Message> findAll()
	{
		List<Message> m = crep.findAll();
		return m;
	}
}
