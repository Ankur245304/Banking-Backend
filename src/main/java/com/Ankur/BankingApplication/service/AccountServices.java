package com.Ankur.BankingApplication.service;

import com.Ankur.BankingApplication.dto.AccountDto;
import com.Ankur.BankingApplication.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AccountServices {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
  List<AccountDto> getAllAccounts();
    AccountDto deposit(Long id,Double amount);
    AccountDto withdraw(Long id,Double amount);
    String deleteAccount(Long id);
    AccountDto fundTransfer(Long id1,Long id2,Double amount);
}
