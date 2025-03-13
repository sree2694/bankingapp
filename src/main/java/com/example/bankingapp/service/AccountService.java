package com.example.bankingapp.service;

import com.example.bankingapp.model.AccountDTO;
import com.example.bankingapp.model.Account;
import com.example.bankingapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(account -> new AccountDTO(account.getId(), account.getAccountNumber(), account.getBalance()))
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return new AccountDTO(account.getId(), account.getAccountNumber(), account.getBalance());
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = new Account(accountDTO.getAccountNumber(), accountDTO.getBalance());
        Account savedAccount = accountRepository.save(account);
        return new AccountDTO(savedAccount.getId(), savedAccount.getAccountNumber(), savedAccount.getBalance());
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
