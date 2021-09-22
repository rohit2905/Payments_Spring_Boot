package com.payments.service;

import java.util.List;

import com.payments.beans.Instruction;

public interface IInstructionService {

	Instruction addMessage(Instruction m);

	Instruction findById(String id);

	List<Instruction> findAll();

	Instruction updateMessage(Instruction m);
	public Instruction getInstructionByMsg(String msg);

}