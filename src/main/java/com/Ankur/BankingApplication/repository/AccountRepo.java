package com.Ankur.BankingApplication.repository;

import com.Ankur.BankingApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
//   @Query("select a from Account a where a.accountHolderName=?1")
   List<Account> findByAccountHolderNameContaining(String accountHolderName);
}
