package com.payments.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payments.beans.Bank;
import com.payments.beans.Customer;
import com.payments.beans.Message;
import com.payments.beans.Transaction;
import com.payments.enums.OD_Enum;
import com.payments.service.IBankService;
import com.payments.service.ICustomerService;
import com.payments.service.IMessageService;
import com.payments.service.ISDNService;
import com.payments.service.ITransactionService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired
	ICustomerService ics;
	@Autowired
	ITransactionService its;
	@Autowired
	IBankService ibs;
	@Autowired
	IMessageService ims;
	@Autowired
	ISDNService isdns;
	double customer_bal;
	boolean check;
	@PostMapping(value="transaction")
	public ResponseEntity<Transaction> AddTrans(@RequestBody Transaction transaction)
	{
		int c=getSDNlist(transaction.getReciever_name());
		
		if(c>0)
		{
			transaction.setTrans_status("FAILED(Sanctioned Name)");
			//return new ResponseEntity<String>("Sanctioned Name",HttpStatus.OK);
		}
		if(customer_bal<transaction.getAmount())
		{
			if(!check)
			{
				transaction.setTrans_status("FAILED(Insufficient Funds)");
				//return new ResponseEntity<String>("Insufficient Funds",HttpStatus.OK);
			}
		}
//		69652133523248
//		45002608912874
//		42895235807723
		if(transaction.getSender_id()==69652133523248L || transaction.getSender_id()==45002608912874L || transaction.getSender_id()==42895235807723L )
		{
			if(!(transaction.getReciever_id()==69652133523248L || transaction.getReciever_id()==45002608912874L || transaction.getReciever_id()==42895235807723L))
			{
				transaction.setTrans_status("FAILED(Transfer Denied from Bank to Customer)");
				//return new ResponseEntity<String>("Transfer Denied to Customer",HttpStatus.OK);
			}
		}
		if(!(transaction.getSender_id()==69652133523248L || transaction.getSender_id()==45002608912874L || transaction.getSender_id()==42895235807723L ))
		{
			if(transaction.getReciever_id()==69652133523248L || transaction.getReciever_id()==45002608912874L || transaction.getReciever_id()==42895235807723L)
			{
				transaction.setTrans_status("FAILED(Transfer Denied from Customer to Bank)");
				//return new ResponseEntity<>("Transfer Denied to Bank",HttpStatus.OK);
			}
		}
		LocalDateTime now = LocalDateTime.now();  
		transaction.setTime_stamp(now);
		System.out.println(transaction);
		its.addTransaction(transaction);
		return new ResponseEntity<>(transaction,HttpStatus.OK);
	}
	
	@GetMapping(value="message")
	public ResponseEntity<List<Message> > getMes()
	{
		List<Message> m = ims.findAll();
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	@RequestMapping("Customer")
	public String index()
	{
		return "Customer";
	}
	@GetMapping(value = "transaction/{id}")
	public ResponseEntity<Transaction> getTrans(@PathVariable("id") int trans_id)
	{
		return new ResponseEntity<>(its.findById(trans_id),HttpStatus.OK);
		
		//return its.findById(trans_id);
		//return t;
	}
	
	@GetMapping(value = "customer/{id}")
	public Customer getcust(@PathVariable("id") long id)
	{
		Customer cust=ics.findById(id);
		customer_bal=cust.getBalance();
		check="Yes"==cust.getOver_draft().toString();
		
		return cust;
		//return t;
	}
	
	@GetMapping(value = "bank/{bic}")
	public Bank getbank(@PathVariable("bic") String bic)
	{
		return ibs.findById(bic);
	}
	
	@GetMapping(value = "message/{msg}")
	public Message getmessage(@PathVariable("msg") String msg)
	{
		return ims.findById(msg);
	}
	
	@GetMapping(value = "clearbalance/{id}")
	public ResponseEntity<Double> getBalance(@PathVariable("id") long id)
	{
		double balance= ics.findBalance(id);
		double total_transaction_amount= its.findtotbalance(id);
		double final_bal = balance - total_transaction_amount;
		return new ResponseEntity<>(final_bal,HttpStatus.OK);
	}
	
	@GetMapping(value = "overdraft/{id}")
	public ResponseEntity<Boolean> getOD(@PathVariable("id") long id)
	{
		OD_Enum en ;
		Customer op1 = ics.findById(id);
		en=op1.getOver_draft();
		String odd =en.toString();
		return new ResponseEntity<>(odd.equals("Yes"),HttpStatus.OK);
		//return new ResponseEntity<>(false,HttpStatus.OK);
			
		
		//return its.findById(trans_id);
		//return t;
	}
	
	public int getSDNlist(@PathVariable("sdnname") String n)
	{
		List<String> names = isdns.getnames();
		int i,l=names.size(),flag=0;
		String s2=n;
		s2 = s2.replaceAll("[^a-zA-Z0-9 ]", "");
		s2=s2.toLowerCase();
		String[] arrOfStr = s2.split(" ");
		Arrays.sort(arrOfStr);
		StringBuffer sb1 = new StringBuffer();
	    for(i = 0; i < arrOfStr.length; i++)
	       sb1.append(arrOfStr[i]);
	    String str1 = sb1.toString();
	    
		for(int j=0;j<l;j++)
		{
			String s1=names.get(j);
			s1 = s1.replaceAll("[^a-zA-Z0-9 ]", "");
			s1=s1.toLowerCase();
			String[] arrOfStr1 = s1.split(" ");
			Arrays.sort(arrOfStr1);
			StringBuffer sb = new StringBuffer();
		    for(i = 0; i < arrOfStr1.length; i++)
		       sb.append(arrOfStr1[i]);
		    String str = sb.toString();
		    if(str.equals(str1))
		    	flag=1;
		    
		    //System.out.println(str);
		}
		return flag;
			
	}
	
	
	
}
