package com.anudip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.entity.Account;
import com.anudip.repository.AccountRepo;
import com.anudip.service.IAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepo accountRepo;
    @Autowired
    private IAccountService accountService;


    AccountController(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    	Account savedAccount = accountService.saveAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount); 
        }

    @GetMapping("/findBy/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return accountRepo.findById(id)
                          .map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
}

