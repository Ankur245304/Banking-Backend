package com.Ankur.BankingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto {
    private Long account_no;
    private String accountHolderName;
    private double balance;

}
