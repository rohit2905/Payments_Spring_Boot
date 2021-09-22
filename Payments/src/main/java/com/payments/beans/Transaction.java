package com.payments.beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	private long sender_acc_no;
	private String message_code;
	private String receiver_name;
	private long receiver_acc_no;
	private String transaction_type;
	private double transaction_fee;
	private String BIC;
	private String t_date;
	public long getSender_acc_no() {
		return sender_acc_no;
	}
	public void setSender_acc_no(long sender_acc_no) {
		this.sender_acc_no = sender_acc_no;
	}
	public String getT_Date() {
		return t_date;
	}
	public void setT_Date(String t_date) {
		this.t_date = t_date;
	}
	//private String sender_name;
	private long amount;
	
	
//	public String getSender_name() {
//		return sender_name;
//	}
//	public void setSender_name(String sender_name) {
//		this.sender_name = sender_name;
//	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transaction_id, long acc_no, String message_code, String receiver_name, long receiver_acc_no,
			String transaction_type, double transaction_fee, String BIC, long amount, String t_date) {
		super();
		this.transaction_id = transaction_id;
		this.sender_acc_no = acc_no;
		this.message_code = message_code;
		this.receiver_name = receiver_name;
		this.receiver_acc_no = receiver_acc_no;
		this.transaction_type = transaction_type;
		this.transaction_fee = transaction_fee;
		this.BIC=BIC;
		this.amount=amount;
		this.t_date=t_date;
		//this.sender_name=sender_name;
	}
	
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String BIC) {
		this.BIC=BIC;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public long getAcc_no() {
		return sender_acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.sender_acc_no = acc_no;
	}
	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public long getReceiver_acc_no() {
		return receiver_acc_no;
	}
	public void setReceiver_acc_no(long receiver_acc_no) {
		this.receiver_acc_no = receiver_acc_no;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getTransaction_fee() {
		return transaction_fee;
	}
	public void setTransaction_fee(double transaction_fee) {
		this.transaction_fee = transaction_fee;
	}

}
