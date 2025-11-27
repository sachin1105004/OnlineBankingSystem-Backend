package com.anudip.service;

import java.util.List;

import com.anudip.entity.Account;

public interface IAccountService {
	Account saveAccount(Account account);
	
    Account getAccountById(Long id);
    
    List<Account> getAllAccounts();
}
