package com.anudip.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anudip.entity.Account;


@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
Optional<Account>findByAccNumber(String accNumber);
	
}
