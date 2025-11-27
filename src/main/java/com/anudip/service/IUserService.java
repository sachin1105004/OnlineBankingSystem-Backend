package com.anudip.service;

import java.util.List;

import com.anudip.entity.User;

public interface IUserService {

	User saveUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
}
