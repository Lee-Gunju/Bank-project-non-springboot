package controller;

import org.bank.controller.AccountController;
import org.bank.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountControllerTest {

    @Test
    void testCreateAndDisplayAccount() {
        AccountController accountController = new AccountController();
        Account account = accountController.getAccountDetails(1L);
        assertNotNull(account);
    }
}