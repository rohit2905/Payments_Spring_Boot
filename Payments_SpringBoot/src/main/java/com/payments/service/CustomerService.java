package com.payments.service;



import com.payments.beans.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

	Customer findByAccNo(long id);
	List<Customer> findAll();
	Optional<Customer> updateCustomer(Customer customer, long acc_no);
	Customer addCustomer(Customer customer);
	void deleteCustomer(long acc_no);

}
