package com.payments.service;

import com.payments.beans.Customer;

public interface ICustomerService {

	Customer findById(long id);

	double findBalance(long id);

}