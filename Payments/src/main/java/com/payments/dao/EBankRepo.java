package com.payments.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.beans.EBank;

@Repository
public interface EBankRepo extends JpaRepository<EBank, String>{

}
