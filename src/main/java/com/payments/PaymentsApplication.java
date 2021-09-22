package com.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.payments.beans.Bank;
import com.payments.beans.Customer;
import com.payments.beans.Message;
import com.payments.controller.CustomerController;
import com.payments.service.BankService;
import com.payments.service.CustomerService;
import com.payments.service.IBankService;
import com.payments.service.ICustomerService;
import com.payments.service.IMessageService;
import com.payments.service.MessageService;

@SpringBootApplication
public class PaymentsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PaymentsApplication.class, args);
		ICustomerService c = context.getBean(CustomerService.class);
		Customer cu1;
		long l = 13645221972859L;
		cu1=c.findById(l);
		System.out.println(cu1);
		IBankService b = context.getBean(BankService.class);
		Bank b1;
		b1=b.findById("ABBLINBBXXX");
		System.out.println(b1);
		IMessageService m = context.getBean(MessageService.class);
		Message m1;
		m1=m.findById("CHQB");
		System.out.println(m1);
	}

}
