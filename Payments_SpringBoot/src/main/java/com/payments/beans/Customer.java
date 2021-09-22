package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "Customer")
public class Customer {
	@Id
	private long acc_no;
	private String acc_holder;
	private double credit_balance;
	private String overdraft;
	public Customer(String acc_holder, long acc_no, double credit_balance, String overdraft) {
		super();
		this.acc_holder = acc_holder;
		this.acc_no = acc_no;
		this.credit_balance = credit_balance;
		this.overdraft = overdraft;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getacc_holder() {
		return acc_holder;
	}
	public void setacc_holder(String acc_holder) {
		this.acc_holder = acc_holder;
	}
	public long getacc_no() {
		return acc_no;
	}
	public void setacc_no(long acc_no) {
		this.acc_no = acc_no;
	}
	public double getCredit_balance() {
		return credit_balance;
	}
	public void setCredit_balance(double credit_balance) {
		this.credit_balance = credit_balance;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
	

}
