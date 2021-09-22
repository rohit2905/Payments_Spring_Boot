package com.payments.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdn")
public class SDN {
	@Id
	private String sdn_name;

	public SDN(String sdn_name) {
		super();
		this.sdn_name = sdn_name;
	}

	public SDN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSdn_name() {
		return sdn_name;
	}

	public void setSdn_name(String sdn_name) {
		this.sdn_name = sdn_name;
	}

}
