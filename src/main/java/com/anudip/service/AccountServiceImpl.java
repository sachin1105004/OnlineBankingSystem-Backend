package com.anudip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Account;
import com.anudip.entity.User;
import com.anudip.repository.AccountRepo;
import com.anudip.repository.UserRepo;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	private AccountRepo repo;
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
    public Account saveAccount(Account account) {
		 User existingUser = userRepo.findById(account.getUser().getId())
                 .orElseThrow(() -> new RuntimeException("User not foundwith ID:" + account.getUser().getId()));
		 account.setUser(existingUser);
        return repo.save(account);
	}
	
	
	
	@Override
    public Account getAccountById(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Account not found with id " + id) );
		
	}
	
	@Override
	public List<Account> getAllAccounts() {
		return repo.findAll();
	}
	
}
