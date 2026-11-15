package com.preactice.integrate.api.transactions_api_integration.service;

import com.preactice.integrate.api.transactions_api_integration.dto.AccountCreateRequest;
import com.preactice.integrate.api.transactions_api_integration.dto.AccountResponse;
import com.preactice.integrate.api.transactions_api_integration.model.Account;
import com.preactice.integrate.api.transactions_api_integration.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public AccountResponse createAccount(AccountCreateRequest request) {
        if (accountRepository.existsById(request.getAccountId())) {
            throw new IllegalArgumentException("Account with ID " + request.getAccountId() + " already exists.");
        }

        Account account = new Account(
                request.getAccountId(),
                request.getAccountName(),
                request.getCurrency(),
                request.getInitialBalance()
        );

        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount);
    }

    @Transactional(readOnly = true)
    public AccountResponse getAccount(String accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountId));
        return new AccountResponse(account);
    }
}