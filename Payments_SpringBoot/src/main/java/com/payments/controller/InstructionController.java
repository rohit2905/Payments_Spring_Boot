package com.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payments.beans.Instruction;
import com.payments.service.IInstructionService;

@CrossOrigin
@RestController
public class InstructionController {
	
	@Autowired
	IInstructionService instructionService;
	
	@GetMapping(value="instruction")
	public List<Instruction> getInstructions(){
		return instructionService.findAll();
	}
	
	@GetMapping(value="instruction/{message_code}")
	public Instruction getInstructionByMsg(@PathVariable("message_code") String message_code){
		return instructionService.getInstructionByMsg(message_code);
		
	}
}
