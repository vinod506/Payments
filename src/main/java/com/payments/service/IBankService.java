package com.payments.service;

import com.payments.beans.Bank;

public interface IBankService {

	Bank findById(String bic);

}