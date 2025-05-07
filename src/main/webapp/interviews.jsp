<%@ page import="java.util.List" %>
<%@ page import="org.cms.model.Interview" %>
<%@ page import="DOA.InterviewDOA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Interviews</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }
        h2 { text-align: center; }
        .interview-container { width: 80%; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 10px; }
        .interview { border-bottom: 1px solid #ccc; padding: 10px 0; }
        .interview:last-child { border-bottom: none; }
        .interview-title { font-size: 1.2em; font-weight: bold; }
        .interview-info { margin-top: 5px; }
    </style>
</head>
<body>
    <h2>My Interview Schedule</h2>

    <div class="interview-container">
        <%
            String username = (String) session.getAttribute("username");
            if (username == null) {
        %>
                <p>You must be logged in to view your interviews.</p>
        <%
            } else {
                try {
                    InterviewDOA interviewDAO = new InterviewDOA();
                    List<Interview> interviews = interviewDAO.getUserInterviews(username);
                    if (interviews.isEmpty()) {
        %>
                        <p>No interviews scheduled.</p>
        <%
                    } else {
                        for (Interview interview : interviews) {
        %>
                            <div class="interview">
                                <div class="interview-title"><%= interview.getCompanyName() %></div>
                                <div class="interview-info">Date: <%= interview.getInterviewDate() %></div>
                                <div class="interview-info">Location <%= interview.getLocation() %></div>
                            </div>
        <%
                        }
                    }
                } catch (Exception e) {
                    out.println("<p>Error loading interviews: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            }
        %>
    </div>
</body>
</html>
