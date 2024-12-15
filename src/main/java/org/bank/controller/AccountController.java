package org.bank.controller;

import org.bank.model.Account;
import org.bank.service.AccountService;

public class AccountController {
    private final AccountService accountService = new AccountService();

    public void createAccount(Long id, String name, Double initialBalance) {
        accountService.createAccount(id, name, initialBalance);
    }

    public void displayAccount(Long id) {
        Account account = accountService.getAccountDetail(id);
        if (account != null) {
            System.out.println("계좌 정보: " + account.getAccountHolderName() + ", 잔액 " + account.getBalance());
        } else {
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    public Account getAccountDetails(long id) {
        return accountService.getAccountDetail(id);
    }
}
