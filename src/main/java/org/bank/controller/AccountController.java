package org.bank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.bank.model.Account;
import org.bank.service.AccountService;

public class AccountController {
    private final AccountService accountService = new AccountService();
    private static final Logger logger = LogManager.getLogger(AccountController.class);

    public void createAccount(Long id, String name, Double initialBalance) {
        accountService.createAccount(id, name, initialBalance);
        logger.info("Request to create account for: " + name);
    }

    public void displayAccount(Long id) {
        Account account = accountService.getAccountDetail(id);
        if (account != null) {
            logger.info("Displaying account for ID: " + id);
            System.out.println("계좌 정보: " + account.getAccountHolderName() + ", 잔액 " + account.getBalance());
        } else {
            logger.warn("Account not found for ID: " + id);
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    public Account getAccountDetails(long id) {
        logger.info("Fetching account details for ID: " + id);
        return accountService.getAccountDetail(id);
    }
}
