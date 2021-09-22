package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instruction")
public class Instruction {
	@Id
	private String message_code;
	private String ins_msg;
	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public String getins_msg() {
		return ins_msg;
	}
	public void setins_msg(String ins_msg) {
		this.ins_msg = ins_msg;
	}
	public Instruction(String message_code, String ins_msg) {
		super();
		this.message_code = message_code;
		this.ins_msg = ins_msg;
	}
	public Instruction() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
