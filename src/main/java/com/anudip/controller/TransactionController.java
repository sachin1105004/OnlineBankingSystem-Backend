package com.anudip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.entity.Transaction;
import com.anudip.service.ITransactionService;



@RestController
@RequestMapping("/txn")
public class TransactionController {
	@Autowired
    private ITransactionService transactionService;
    
    
    public TransactionController(ITransactionService transactionService) {
    	this.transactionService = transactionService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
    	Transaction savedTransaction = transactionService.saveTransaction(transaction);
    	return ResponseEntity.ok(savedTransaction);
    	
    }
    
    @GetMapping("/account/{accNumber}")
    public ResponseEntity<List<Transaction>> getTransactionByAccount(@PathVariable String accNumber){
    	List<Transaction> transactions = transactionService.getTransactionsByAccount(accNumber);
    	if (transactions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }
    
    @GetMapping("/txnHistory")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        if (transactions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }
    
    @GetMapping("/txnById/{id}")
    public ResponseEntity<Transaction>getTransactionsById(@PathVariable Long id){
    	Transaction transaction = transactionService.getTransactionsById(id);
    	return ResponseEntity.ok(transaction);
    }
    
    
    
    
    

}
