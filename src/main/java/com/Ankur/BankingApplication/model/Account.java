package com.Ankur.BankingApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Table(name = "Accounts")
@Entity
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_no;
    @Column(name = "account_holderName")
    private String accountHolderName;
    private double balance;
}
