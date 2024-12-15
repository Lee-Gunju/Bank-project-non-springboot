package org.bank;

import org.bank.controller.AccountController;
import org.bank.model.Account;

public class Main {
    public static void main(String[] args) {
        // AccountController 객체 생성
        AccountController accountController = new AccountController();

        // 1. 계좌 생성
        System.out.println("Creating accounts...");
        accountController.createAccount(1L, "Alice", 5000.0);
        accountController.createAccount(2L, "Bob", 3000.0);

        // 2. 계좌 조회
        System.out.println("\nFetching account details...");
        Account aliceAccount = accountController.getAccountDetails(1L);
        Account bobAccount = accountController.getAccountDetails(2L);

        System.out.println("Alice's Account: " + aliceAccount);
        System.out.println("Bob's Account: " + bobAccount);

        // 3. 잘못된 계좌 조회
        System.out.println("\nFetching non-existing account...");
        Account nonExistingAccount = accountController.getAccountDetails(99L);
        System.out.println("Non-existing Account: " + nonExistingAccount);

        // 4. 출력 결과 확인
        System.out.println("\nMain function execution completed.");
    }
}