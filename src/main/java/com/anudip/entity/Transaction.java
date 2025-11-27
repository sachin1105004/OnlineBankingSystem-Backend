package com.anudip.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

@Id
@GeneratedValue

private Long id;
private String fromAccount;
private String toAccount;

public Transaction() {
	
}

public Transaction(String toAccount) {
	super();
	this.toAccount = toAccount;
}
@Override
public String toString() {
	return "Transaction [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
			+ ", dateTime=" + dateTime + "]";
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFromAccount() {
	return fromAccount;
}
public void setFromAccount(String fromAccount) {
	this.fromAccount = fromAccount;
}
public String getToAccount() {
	return toAccount;
}
public void setToAccount(String toAccount) {
	this.toAccount = toAccount;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public LocalDateTime getDateTime() {
	return dateTime;
}
public void setDateTime(LocalDateTime dateTime) {
	this.dateTime = dateTime;
}
private Double amount;
private LocalDateTime dateTime;


}
