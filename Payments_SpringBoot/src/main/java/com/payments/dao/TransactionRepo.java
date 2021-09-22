package com.payments.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.payments.beans.Transaction;
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {

}
