package com.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.EBank;
import com.payments.dao.EBankRepo;

@Service
public class EBankService implements IEBankService {
	
	@Autowired
	EBankRepo eBankRepo;
	@Override
	public EBank addBank(EBank bic)
	{
	return eBankRepo.save(bic);
	}
	@Override
	public EBank getEBankByBIC(String id)
	{
		return eBankRepo.findById(id).get();
	}
	@Override
	public List<EBank> findAll() {
		
		return  eBankRepo.findAll();	}
	
	@Override
	public EBank updateBank(EBank bi)
	{
		return eBankRepo.save(bi);
	}
	{
		
	}
	@Override
	public Object findById(String bIC) {
		// TODO Auto-generated method stub
		return eBankRepo.findById(bIC).get();
	
	}
	
	

}