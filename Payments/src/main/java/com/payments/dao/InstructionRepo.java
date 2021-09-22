package com.payments.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.beans.Instruction;

@Repository
public interface InstructionRepo extends JpaRepository<Instruction, String> {
	
}
