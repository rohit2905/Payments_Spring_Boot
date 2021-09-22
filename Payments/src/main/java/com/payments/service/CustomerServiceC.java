package com.payments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.Customer;
import com.payments.dao.CustomerRepo;

@Service
public class CustomerServiceC implements CustomerService{
	@Autowired
	CustomerRepo customerRepo;
	
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findByAccNo(long id) {
		
		return customerRepo.findById(id).get();
	}

	@Override
	public Customer addCustomer(Customer customerrepor) {
		// TODO Auto-generated method stub
//		Customer newcusCustomer= new Customer();
//		newcusCustomer.setacc_holder(customerrepor.getacc_holder());
//		newcusCustomer.setacc_no(customerrepor.getacc_no());
//		newcusCustomer.setCredit_balance(customerrepor.getCredit_balance());
//		newcusCustomer.setOverdraft(customerrepor.getOverdraft());
//		 customerRepo.save(newcusCustomer);
//		 return newcusCustomer;
		return customerRepo.save(customerrepor);
	}
	


	@Override
	public Optional<Customer> updateCustomer(Customer customer, long acc_no) {
		// TODO Auto-generated method stub
		Optional<Customer> customerOptional = customerRepo.findById(acc_no);
		customerOptional.get().setacc_holder(customer.getacc_holder());
		customerOptional.get().setacc_no(customer.getacc_no());
		customerOptional.get().setOverdraft(customer.getOverdraft());
		customerOptional.get().setCredit_balance(customer.getCredit_balance());
		 customerRepo.save(customerOptional.get());
		 return customerOptional;
	}

	@Override
	public void deleteCustomer(long acc_no){
		// TODO Auto-generated method stub
		if(customerRepo.getById(acc_no).getacc_no() == acc_no)
			customerRepo.deleteById(acc_no);
		
	}
	


	
}
