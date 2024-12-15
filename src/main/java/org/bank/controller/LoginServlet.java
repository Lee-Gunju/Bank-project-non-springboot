package org.bank.controller;

import org.bank.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 데이터베이스를 사용한 인증 로직
        if (userRepository.validateUser(username, password)) {
            response.sendRedirect("/view/index.jsp");
        } else {
            response.sendRedirect("/view/login.jsp?error=true");
        }
    }
}
