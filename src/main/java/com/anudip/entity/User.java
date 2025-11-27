package com.anudip.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	  
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String location;
private String contactNo;


@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<Account> accounts;
	

public User() {};
public User(Long id, String name, String location, String contactNo, List<Account> accounts) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
	this.contactNo = contactNo;
	this.accounts = accounts;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", location=" + location + ", contactNo=" + contactNo + ", accounts="
			+ accounts + "]";
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public List<Account> getAccounts() {
	return accounts;
}

public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
}




}
