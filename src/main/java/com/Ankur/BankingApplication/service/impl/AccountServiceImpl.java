package com.Ankur.BankingApplication.service.impl;

import com.Ankur.BankingApplication.dto.AccountDto;
import com.Ankur.BankingApplication.mapper.AccountMapper;
import com.Ankur.BankingApplication.model.Account;
import com.Ankur.BankingApplication.repository.AccountRepo;
import com.Ankur.BankingApplication.service.AccountServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountServices {
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
    Account savedAccount=accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        return accountRepo.findById(id)
                .map(AccountMapper::mapToAccountDto)
                .orElseThrow(() -> new EntityNotFoundException("Account with ID " + id + " not found"));
    }


    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accountsList=accountRepo.findAll();
       List<AccountDto> accountDtos=new ArrayList<>();
       for(Account account:accountsList)
       {
           accountDtos.add(AccountMapper.mapToAccountDto(account));
       }
       return accountDtos;
    }


    @Override
    public AccountDto deposit(Long id,Double amount) {
        AccountDto accountDto= getAccountById(id);
        accountDto.setBalance(accountDto.getBalance()+amount);
        Account updatedAccount=accountRepo.save(AccountMapper.mapToAccount(accountDto));

        return AccountMapper.mapToAccountDto(updatedAccount);

    }

    @Override
    public AccountDto withdraw(Long id,Double amount) {
        AccountDto accountDto= getAccountById(id);
        if(accountDto.getBalance()<=amount)
            throw  new IllegalArgumentException("Insufficient Balance");
        else
            accountDto.setBalance(accountDto.getBalance()-amount);
        Account updatedAccount=accountRepo.save(AccountMapper.mapToAccount(accountDto));

        return AccountMapper.mapToAccountDto(updatedAccount);

    }

    @Override
    public String deleteAccount(Long id) {
        AccountDto accountDto= getAccountById(id);
        accountRepo.deleteById(id);
        return "Deleted";


    }

    @Override
//    @Transactional
    public AccountDto fundTransfer(Long id1, Long id2, Double amount) {
        AccountDto sender=getAccountById(id1);
        AccountDto recipent=getAccountById(id2);
        sender=withdraw(id1,amount);
        recipent=deposit(id2,amount);
        return recipent;

    }

}
