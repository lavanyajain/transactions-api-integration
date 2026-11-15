package com.preactice.integrate.api.transactions_api_integration.repository;

import com.preactice.integrate.api.transactions_api_integration.model.Account;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    /**
     * Fetches an account by ID and locks the underlying database row for writing.
     * Any other transaction trying to read or lock this same account row will
     * block until the current transaction completes.
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Account a WHERE a.accountId = :accountId")
    Optional<Account> findByIdWithLock(@Param("accountId") String accountId);
}
