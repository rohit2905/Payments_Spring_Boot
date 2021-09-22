package com.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.SDN;
import com.payments.dao.SDNRepo;

@Service
public class SDNService implements ISDN {
	
	@Autowired
	SDNRepo sdnRepo;
	
	@Override
	public List<SDN> getNames() {
		return sdnRepo.findAll();
		
	}

}
