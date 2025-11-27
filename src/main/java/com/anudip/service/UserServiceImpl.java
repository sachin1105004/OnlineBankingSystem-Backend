package com.anudip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.User;
import com.anudip.repository.UserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public User saveUser(User user) {
		 return repo.save(user);
		 
	}
	
	@Override
	public User getUserById(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("User not found with id " + id));
	}
	
	@Override
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	 
	
}
