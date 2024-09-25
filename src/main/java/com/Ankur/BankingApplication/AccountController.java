package com.Ankur.BankingApplication;

import com.Ankur.BankingApplication.dto.AccountDto;
import com.Ankur.BankingApplication.model.Account;
import com.Ankur.BankingApplication.service.AccountServices;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountServices service;

    //Add account Rest API
    @PostMapping()
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
    }
    //Get All accounts Rest API
    @GetMapping()
    public List<AccountDto> getAllAccounts()
    {

        return service.getAllAccounts();
    }
    //Get Account By id REST API
    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable("id") Long id)
    {
        System.out.println(id);
        return  service.getAccountById(id);
    }
    @PatchMapping("deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable("id") Long id,@RequestParam()Double amount)
    {
        AccountDto accountDto= service.deposit(id,amount);
        return  ResponseEntity.ok(accountDto);
    }
    @PatchMapping("withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable("id") Long id,@RequestParam()Double amount)
    {
        AccountDto accountDto= service.withdraw(id,amount);
        return  ResponseEntity.ok(accountDto);
    }
    @DeleteMapping("{id}")
    public String deleteAccount(@PathVariable("id") Long id)
    {
      return  service.deleteAccount(id);
    }
    @PatchMapping("transferFunds")
    public AccountDto transferFunds(@RequestParam("sender")Long id1,@RequestParam("receiver")Long id2,@RequestParam("amount")Double amount)
    {
     return service.fundTransfer(id1,id2,amount);
    }



}
