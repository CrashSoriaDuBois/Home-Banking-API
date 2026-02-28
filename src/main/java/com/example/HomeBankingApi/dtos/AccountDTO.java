package com.example.HomeBankingApi.dtos;

import com.example.HomeBankingApi.models.Account;
import com.example.HomeBankingApi.models.Client;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
public class AccountDTO {
    public long id;
    public String number;
    public LocalDate creationDate;
    public double balance;
    private Set<TransactionDTO> transactions;
    public AccountDTO(){}
    public AccountDTO(Account account){
        this.id = account.getAccountID();
        this.number = account.getNumber();
        this.creationDate = account.getCreationDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountDTO(Set<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
