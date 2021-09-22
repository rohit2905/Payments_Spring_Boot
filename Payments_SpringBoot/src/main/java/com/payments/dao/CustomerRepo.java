package com.payments.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.beans.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
