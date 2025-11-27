package com.anudip.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "accounts")
public class Account {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String accNumber;
private Double balance;

@ManyToOne
@JoinColumn(name="user_id")
private User user;

	public Account() {};
public Account(Long id, String accNumber, Double balance, User user) {
	super();
	this.id = id;
	this.accNumber = accNumber;
	this.balance = balance;
	this.user = user;
}

@Override
public String toString() {
	return "Account [id=" + id + ", accNumber=" + accNumber + ", balance=" + balance + ", user=" + user + "]";
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAccNumber() {
	return accNumber;
}

public void setAccNumber(String accNumber) {
	this.accNumber = accNumber;
}

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


}
