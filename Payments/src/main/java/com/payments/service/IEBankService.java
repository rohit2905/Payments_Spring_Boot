package com.payments.service;

import java.util.List;

import com.payments.beans.EBank;

public interface IEBankService {

	EBank addBank(EBank bi);

	public EBank getEBankByBIC(String bic);

	List<EBank> findAll();

	EBank updateBank(EBank bi);

	Object findById(String bIC);
}
