package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.model.Customer;

@Entity
@Table(name="Account")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int act_number;
	private int act_balance;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private CustomerEntity customerentity;
	public int getAct_number() {
		return act_number;
	}
	public void setAct_number(int act_number) {
		this.act_number = act_number;
	}
	public int getAct_balance() {
		return act_balance;
	}
	public void setAct_balance(int act_balance) {
		this.act_balance = act_balance;
	}
	public CustomerEntity getCustomerentity() {
		return  customerentity;
	}
	public void setCustomerentity(CustomerEntity customerentity) {
		this.customerentity =  customerentity;
	}
	

	
	
}
