package com.anudip.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Account;
import com.anudip.entity.Transaction;
import com.anudip.repository.AccountRepo;
import com.anudip.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	private TransactionRepo repo;
	
	@Autowired 
	private AccountRepo accRepo;
	
	@Override
	public Transaction saveTransaction(Transaction txn) {
		//from which account amount will be deducted
		Account fromAcc = accRepo.findByAccNumber(txn.getFromAccount()).orElseThrow(
				() -> new RuntimeException("From account not found"));
		//to which account amount will be credit
		Account toAcc = accRepo.findByAccNumber(txn.getToAccount()).orElseThrow(
				() -> new RuntimeException("To account not found"));
		//check balance
        if (fromAcc.getBalance() < txn.getAmount()) {
            throw new RuntimeException("Insufficient balance");
        }
        //deduct amount
        fromAcc.setBalance(fromAcc.getBalance() - txn.getAmount());
        //credit amount
        toAcc.setBalance(toAcc.getBalance() + txn.getAmount());
		
        accRepo.save(fromAcc);
        
        accRepo.save(toAcc);
        
        txn.setDateTime(LocalDateTime.now());
        
        return repo.save(txn);
   
	}
	
	@Override
	public Transaction getTransactionsById(Long id){
		return repo.findById(id).orElse(null);
	}
	
	@Override
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }
	
	@Override
	public  List<Transaction> getTransactionsByAccount(String accNumber){
		return repo.findByFromAccountOrToAccount(accNumber, accNumber);
	}
	
	
	

}
