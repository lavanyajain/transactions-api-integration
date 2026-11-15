package com.preactice.integrate.api.transactions_api_integration.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private String accountId;

    @Column(nullable = false)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyEnum currency;

    @Column(nullable = false)
    private Long balance; // stored in smallest unit (cents)

    @Version
    private Long version; // Optimistic locking backup

    // 1. Required by JPA/Hibernate
    protected Account() {}

    // 2. Convenient constructor for seeding or creation
    public Account(String accountId, String accountName, CurrencyEnum currency, Long balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.currency = currency;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getVersion() {
        return version;
    }
}