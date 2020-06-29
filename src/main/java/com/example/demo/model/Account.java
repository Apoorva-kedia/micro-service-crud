package com.example.demo.model;

import java.util.List;

public class Account {
	
	private int act_number;
	private int act_balance;
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAct_balance() {
		return act_balance;
	}

	public void setAct_balance(int act_balance) {
		this.act_balance = act_balance;
	}

	public int getAct_number() {
		return act_number;
	}

	public void setAct_number(int act_number) {
		this.act_number = act_number;
	}

	
}
