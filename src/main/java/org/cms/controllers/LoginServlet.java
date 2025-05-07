package org.cms.controllers;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.cms.model.User;
import DOA.UserDOA;

public class LoginServlet extends HttpServlet {

    // Handle POST request (Processing login form)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the user with UserDOA
        UserDOA userDAO = new UserDOA();
        User user = userDAO.authenticateUser(username, password);  // Assuming this method checks user credentials

        if (user != null) {
            // If user is authenticated, create session and redirect to dashboard
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard");  // Redirect to DashboardServlet
        } else {
            // If authentication fails, show error message and stay on the login page
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginproj.jsp");
            dispatcher.forward(request, response);
        }
    }
}
