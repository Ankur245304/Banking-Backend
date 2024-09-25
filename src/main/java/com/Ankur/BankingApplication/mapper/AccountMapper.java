package com.Ankur.BankingApplication.mapper;

import com.Ankur.BankingApplication.dto.AccountDto;
import com.Ankur.BankingApplication.model.Account;

public class AccountMapper {
    public  static Account mapToAccount(AccountDto accountDto)
    {
        return new Account(accountDto.getAccount_no(), accountDto.getAccountHolderName(), accountDto.getBalance());

    }
    public static AccountDto mapToAccountDto(Account account)
    {
        return new AccountDto(account.getAccount_no(),account.getAccountHolderName(),account.getBalance());
    }
}
