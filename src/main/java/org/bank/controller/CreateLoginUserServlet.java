package org.bank.controller;

import org.bank.repository.UserRepository;
import org.bank.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createLoginUser")
public class CreateLoginUserServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 사용자 존재 여부 확인
        if (userRepository.userExists(username)) {
            response.sendRedirect("/view/createUser.jsp?error=user_exists");
        } else {
            // 새로운 사용자 계정 생성
            if (userRepository.createUser(username, password)) {
                // 동일한 username과 초기 잔액 0으로 계좌 생성
                AccountService accountService = new AccountService();
                accountService.createAccount(null, username, 0.0);
                response.sendRedirect("/view/login.jsp?success=user_created");
            } else {
                response.sendRedirect("/view/createUser.jsp?error=creation_failed");
            }
        }
    }
}