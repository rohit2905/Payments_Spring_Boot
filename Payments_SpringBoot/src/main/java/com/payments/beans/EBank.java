package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="external_bank")
public class EBank {
	@Id
	private String BIC;
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	private String institution_name;
	public EBank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EBank(String bIC, String institution_name) {
		super();
		BIC = bIC;
		this.institution_name = institution_name;
	}
}
