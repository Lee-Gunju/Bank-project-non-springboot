package org.bank.controller;

import org.bank.repository.UserRepository;

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

        // 계정 생성 로직
        if (userRepository.createUser(username, password)) {
            response.sendRedirect("/view/login.jsp?success=true");
        } else {
            response.sendRedirect("/view/login.jsp?error=true");
        }
    }
}