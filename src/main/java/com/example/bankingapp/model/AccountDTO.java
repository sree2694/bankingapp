package com.example.bankingapp.model;

public class AccountDTO {
    private Long id;
    private String accountNumber;
    private Double balance;

    public AccountDTO() {}

    public AccountDTO(Long id, String accountNumber, Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }
}