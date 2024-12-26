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
            AccountRepository accountRepository = new AccountRepository();
            Account retrievedAccount = accountRepository.findById(1L);
            assertNotNull(retrievedAccount);

        }

        @Test
        void testFindAll() {
            AccountRepository accountRepository = new AccountRepository();
            List<Account> accounts = accountRepository.findAll();
        }
    }