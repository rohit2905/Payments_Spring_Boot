package com.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payments.beans.EBank;

import com.payments.service.IEBankService;

@CrossOrigin
@RestController
public class EBankController {
	
	@Autowired
	IEBankService eBankService;
	
	@GetMapping(value="ebank")
	public List<EBank> getEBanks(){
		return eBankService.findAll();
	}
	
	@GetMapping(value="ebank/{BIC}")
	public EBank getEBankByBIC(@PathVariable("BIC") String BIC){
		return eBankService.getEBankByBIC(BIC);
	}
}
