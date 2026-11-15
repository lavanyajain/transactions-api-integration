package com.preactice.integrate.api.transactions_api_integration.dto;

import com.preactice.integrate.api.transactions_api_integration.model.Account;
import com.preactice.integrate.api.transactions_api_integration.model.CurrencyEnum;

public class AccountResponse {
    private String accountId;
    private String accountName;
    private CurrencyEnum currency;
    private Long balance;
    private Long version;

    public AccountResponse(Account account) {
        this.accountId = account.getAccountId();
        this.accountName = account.getAccountName();
        this.currency = account.getCurrency();
        this.balance = account.getBalance();
        this.version = account.getVersion();
    }

    // Getters
    public String getAccountId() { return accountId; }
    public String getAccountName() { return accountName; }
    public CurrencyEnum getCurrency() { return currency; }
    public Long getBalance() { return balance; }
    public Long getVersion() { return version; }
}