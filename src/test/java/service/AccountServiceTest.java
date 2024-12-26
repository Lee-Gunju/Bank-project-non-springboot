package service;

import org.bank.service.AccountService;
import org.bank.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountServiceTest {

    @Test
    void testCreateAccount() {
        AccountService accountService = new AccountService();
        accountService.createAccount(1L, "Alice", 1000.0);
        Account account = accountService.getAccountDetail(1L);
        assertNotNull(account);

    }

    @Test
    void testGetAccountDetail() {
        AccountService accountService = new AccountService();
        accountService.createAccount(2L, "Alice", 2000.0);
        Account account = accountService.getAccountDetail(2L);
        assertNotNull(account);
    }

    @Test
    void testUpdateAccount() {
        AccountService accountService = new AccountService();
        accountService.createAccount(2L, "Alice", 3000.0);
        Account account = accountService.getAccountDetail(3L);
        account.setBalance(3500.0);
        accountService.updateAccount(account);
        Account updatedAccount = accountService.getAccountDetail(3L);
        assertEquals(3500.0, updatedAccount.getBalance());
    }
}
