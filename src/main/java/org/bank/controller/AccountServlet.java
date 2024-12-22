package org.bank.controller;

import org.bank.model.Account;
import org.bank.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/createAccount")
public class AccountServlet extends HttpServlet {
    private final AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("accountHolderName");
        Double balance = Double.parseDouble(request.getParameter("initialBalance"));

        try {
            Account existingAccount = accountService.getAccountDetailByName(name);
            if (existingAccount != null) {
                existingAccount.setBalance(balance);
                accountService.updateAccount(existingAccount);
                response.sendRedirect("/view/index.jsp?success=balance_updated");
            } else {
                response.sendRedirect("/view/index.jsp?error=user_not_found");
            }
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
            e.printStackTrace();
            response.sendRedirect("/view/index.jsp?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountHolderName = request.getParameter("accountHolderName");
        Account account = accountService.getAccountDetailByName(accountHolderName);

        if (account != null) {
            request.setAttribute("accountHolderName", account.getAccountHolderName());
            request.setAttribute("balance", account.getBalance());
            request.getRequestDispatcher("/view/accountDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("/view/index.jsp?error=account_not_found");
        }
    }
}
