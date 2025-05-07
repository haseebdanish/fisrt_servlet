package org.cms.controllers;

import java.io.*;
import java.util.*;

import org.cms.model.Application;
import org.cms.model.Interview;
import org.cms.model.Job;

import DOA.ApplicationDOA;
import DOA.InterviewDOA;
import DOA.JobDOA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user session (if logged in)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // Redirect to login if not logged in
            response.sendRedirect("loginproj.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        // Fetch job list, applications, and interview schedule for this user
        JobDOA jobDAO = new JobDOA();
        ApplicationDOA applicationDAO = new ApplicationDOA();
        InterviewDOA interviewDAO = new InterviewDOA();

        // You can adjust the methods to return the correct user-specific data
        List<Job> jobList = jobDAO.getAvailableJobs();  // Assuming this fetches all jobs
        List<Application> applicationList = applicationDAO.getUserApplications(username); // Get applications by username
        List<Interview> interviewList = interviewDAO.getUserInterviews(username);  // Get interviews for this user

        // Set attributes to forward to Dashboard.jsp
        request.setAttribute("jobList", jobList);
        request.setAttribute("applicationList", applicationList);
        request.setAttribute("interviewList", interviewList);

        // Forward the request to the Dashboard JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboard.jsp");
        dispatcher.forward(request, response);
    }

    // Optional: You can also add a doPost() method if you want to handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

