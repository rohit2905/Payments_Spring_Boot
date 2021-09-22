package com.payments.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payments.beans.MessageResponse;
import com.payments.beans.Transaction;
import com.payments.service.ITransactionService;

@CrossOrigin
@RestController
public class TransactionController {

	@Autowired
	ITransactionService transactionService;
	
	@PostMapping(value="new_t")
	public MessageResponse addTransactions(@RequestBody Transaction transaction)
	{
		return transactionService.addTransaction(transaction);
	}
	
	@GetMapping(value="transaction")
	public List<Transaction> getTransactions() {
		return transactionService.findAll();
	}
	
	@GetMapping(value="transaction/{transaction_id}")
	public Transaction getTransactionByID(@PathVariable("transaction_id") int transaction_id){
		return transactionService.findById(transaction_id);
	}

}
