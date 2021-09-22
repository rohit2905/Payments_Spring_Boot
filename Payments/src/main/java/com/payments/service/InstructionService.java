package com.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.Instruction;
import com.payments.dao.InstructionRepo;

@Service
public class InstructionService implements IInstructionService {
	@Autowired
	InstructionRepo instructionRepo;
	
	@Override
	public Instruction addMessage(Instruction message)
	{
		return instructionRepo.save(message);
	}
	
	@Override
	public Instruction findById(String id)
	{
		return instructionRepo.getById(id);
	}
	@Override
	public List<Instruction> findAll() {
		// TODO Auto-generated method stub
		return instructionRepo.findAll();	}



	@Override
	public Instruction updateMessage(Instruction m) {
		// TODO Auto-generated method stub
		return instructionRepo.save(m);
	}

	@Override
	public Instruction getInstructionByMsg(String msg) {
		// TODO Auto-generated method stub
		return instructionRepo.getById(msg);
	}
	

}
