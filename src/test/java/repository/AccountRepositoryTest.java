package repository;

import org.bank.model.Account;
import org.bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountRepositoryTest {

    @Test
    void testSaveAndFindById() {
        // Arrange
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account(1L, "Alice", 5000.0);

        // Act
        accountRepository.save(account);
        Account retrievedAccount = accountRepository.findById(1L);

        // Assert
        assertNotNull(retrievedAccount);
        assertEquals("Alice", retrievedAccount.getAccountHolderName());
        assertEquals(5000.0, retrievedAccount.getBalance());
    }

    @Test
    void testFindAll() {
        // Arrange
        AccountRepository accountRepository = new AccountRepository();
        accountRepository.save(new Account(1L, "Alice", 5000.0));
        accountRepository.save(new Account(2L, "Bob", 3000.0));

        // Act
        List<Account> accounts = accountRepository.findAll();

        // Assert
        assertEquals(2, accounts.size());
    }
}