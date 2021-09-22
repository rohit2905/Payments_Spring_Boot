package com.payments.service;


import java.util.List;

import com.payments.beans.MessageResponse;
import com.payments.beans.Transaction;

public interface ITransactionService {

	MessageResponse addTransaction(Transaction tr);

	Transaction findById(int id);

	List<Transaction> findAll();

	Transaction updateTransaction(Transaction t);

}