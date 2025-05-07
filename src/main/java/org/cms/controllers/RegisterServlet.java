package org.cms.controllers;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.cms.model.User;
import DOA.UserDOA;

public class RegisterServlet extends HttpServlet {

    // Handle GET request to show the registration page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("registerproj.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST request to process the registration form
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user details from the registration form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        // Validate inputs (you can add more validations as needed)
        if (username == null || password == null || email == null || username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registerproj.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Create User object to store data in the database
        User user = new User( 0, username, password, email, role);

        // Use DAO to insert the user into the database
        UserDOA userDAO = new UserDOA();
        boolean isRegistered = userDAO.registerUser(user); // Assuming this method inserts the user in the DB

        if (isRegistered) {
            // Redirect to login page after successful registration
            response.sendRedirect("loginproj.jsp");
        } else {
            // Show an error message if registration failed (e.g., username already taken)
            request.setAttribute("errorMessage", "Registration failed! Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registerproj.jsp");
            dispatcher.forward(request, response);
        }
    }
}
