package com.preactice.integrate.api.transactions_api_integration.dto;

import com.preactice.integrate.api.transactions_api_integration.model.CurrencyEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AccountCreateRequest {

    @NotBlank(message = "Account ID is required")
    private String accountId;

    @NotBlank(message = "Account name is required")
    private String accountName;

    @NotNull(message = "Currency is required")
    private CurrencyEnum currency;

    @NotNull(message = "Initial balance is required")
    @Min(value = 0, message = "Initial balance cannot be negative")
    private Long initialBalance; // stored in smallest unit (cents)

    // Getters and Setters
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getAccountName() { return accountName; }
    public void setAccountName(String accountName) { this.accountName = accountName; }

    public CurrencyEnum getCurrency() { return currency; }
    public void setCurrency(CurrencyEnum currency) { this.currency = currency; }

    public Long getInitialBalance() { return initialBalance; }
    public void setInitialBalance(Long initialBalance) { this.initialBalance = initialBalance; }
}