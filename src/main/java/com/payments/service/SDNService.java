package com.payments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.SDN_list;
import com.payments.repo.SDNRepo;

@Service
public class SDNService implements ISDNService {
	@Autowired
	SDNRepo srep;
	
	@Override
	public List<String> getnames()
	{
		List<SDN_list> sdnl= srep.findAll();
		List<String> names = new ArrayList<>();
		int l=sdnl.size();
		for(int i=0;i<l;i++)
		{
			names.add(sdnl.get(i).getName());
		}
		return names;
	}
}
