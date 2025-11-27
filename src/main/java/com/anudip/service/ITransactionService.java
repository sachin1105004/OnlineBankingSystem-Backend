package com.anudip.service;

import java.util.List;

import com.anudip.entity.Transaction;

public interface ITransactionService {
	
	Transaction saveTransaction(Transaction txn);

    List<Transaction> getAllTransactions();

    List<Transaction> getTransactionsByAccount(String accNumber);
    
    Transaction getTransactionsById(Long id);
 
}
