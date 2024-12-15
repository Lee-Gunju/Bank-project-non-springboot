package service;

import org.bank.service.AccountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountServiceTest {

   @Test
   void testCreateAccount() {
       AccountService accountService = new AccountService();
       accountService.createAccount(1L, "John doe", 1000.0);
       assertNotNull(accountService.getAccountDetail(1L));
   }
}
