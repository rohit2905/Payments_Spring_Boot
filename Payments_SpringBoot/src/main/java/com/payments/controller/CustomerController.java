package com.payments.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payments.beans.Customer;

import com.payments.service.CustomerService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	

	@GetMapping(value="customer")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer>  customers = customerService.findAll();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@PostMapping(value="add_customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	
	@PutMapping(value="update_customer/{acc_no}")
	public Optional<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable("acc_no") long acc_no ) {
		return customerService.updateCustomer(customer,acc_no);
	}
	
	@DeleteMapping(value="delete/{acc_no}")
	public void deleteCustomer(@PathVariable("acc_no") long acc_no) {
		
			customerService.deleteCustomer(acc_no);
		
	}


//	@GetMapping(value="customer/{acc_no}")
//	public ResponseEntity<Customer> getCustomerByAcc(@PathVariable("acc_no") long acc_no){
//		  Customer customer = customerService.findByAccNo(acc_no);
//		  return new ResponseEntity<>(customer, HttpStatus.OK);
//		
//	}
	
	@GetMapping(value="customer/{acc_no}")
	public Customer getCustomerByAcc(@PathVariable("acc_no") long acc_no){
		  return customerService.findByAccNo(acc_no);
	}
	
}



	


