package org.bank.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bank.model.Account;
import org.bank.repository.AccountRepository;

public class AccountService {
    private final AccountRepository accountRepository = new AccountRepository();
    private static final Logger logger = LogManager.getLogger(AccountService.class);

    public void createAccount(Long id, String name, Double initialBalance) {
        Account account = new Account(id, name, initialBalance);
        accountRepository.save(account);
        logger.info("Account created: " + account.getAccountHolderName() + ", Initial Balance: " + initialBalance);
        System.out.println("계좌가 생성되었습니다: " + account.getAccountHolderName());
    }

    public Account getAccountDetail(Long id) {
        return accountRepository.findById(id);
    }

    public Account getAccountDetailByName(String accountHolderName) {
        return accountRepository.findByName(accountHolderName);
    }

    public void updateAccount(Account account) {
        accountRepository.update(account);
        logger.info("Account updated: " + account.getAccountHolderName());
        System.out.println("계좌가 업데이트되었습니다: " + account.getAccountHolderName());
    }
}
