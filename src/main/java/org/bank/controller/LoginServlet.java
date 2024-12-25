package org.bank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.info("Login attempt for user: " + username);

        // 데이터베이스를 사용한 인증 로직
        if (!userRepository.userExists(username)) {
            logger.warn("Username not found: " + username);
            response.sendRedirect("/view/login.jsp?error=username_not_found");
        } else if (!userRepository.validateUser(username, password)) {
            logger.warn("Incorrect password for user: " + username);
            response.sendRedirect("/view/login.jsp?error=incorrect_password");
        } else {
            logger.info("User logged in successfully: " + username);
            response.sendRedirect("/view/index.jsp");
        }
    }
}
