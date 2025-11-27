package com.anudip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	List<Transaction> findByFromAccountOrToAccount(String fromAccount, String toAccount );
}
