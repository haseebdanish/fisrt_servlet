<%@ page import="java.util.List" %>
<%@ page import="org.cms.model.Job" %>
<%@ page import="org.cms.model.Application" %>
<%@ page import="org.cms.model.Interview" %>

<%
    List<Job> jobList = (List<Job>) request.getAttribute("jobList");
    List<Application> applicationList = (List<Application>) request.getAttribute("applicationList");
    List<Interview> interviewList = (List<Interview>) request.getAttribute("interviewList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Placement Management System</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Placement System</a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="profile.jsp">Profile</a></li>
        <li class="nav-item"><a class="nav-link" href="jobs.jsp">Jobs</a></li>
        <li class="nav-item"><a class="nav-link" href="Applications.jsp">Applications</a></li>
        <li class="nav-item"><a class="nav-link" href="interviews.jsp">Interviews</a></li>
        <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Main Dashboard Section -->
<div class="container my-5">

    <div class="text-center mb-5">
        <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
        <p class="lead">Role: <%= session.getAttribute("role") %></p>
    </div>

    <div class="row g-4">

        <!-- Available Jobs -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow h-100">
                <div class="card-body">
                    <h5 class="card-title">Available Jobs</h5>
                    <ul class="list-group list-group-flush mb-3">
                        <% 
                        int count = 0;
                        for (Job job : jobList) {
                            if (count >= 2) break;
                        %>
                            <li class="list-group-item"><%= job.getTitle() %> - <%= job.getCompanyName() %></li>
                        <%
                            count++;
                        }
                        %>
                    </ul>
                    <a href="jobs.jsp" class="btn btn-primary w-100">View All Jobs</a>
                </div>
            </div>
        </div>

        <!-- My Applications -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow h-100">
                <div class="card-body">
                    <h5 class="card-title">My Applications</h5>
                    <ul class="list-group list-group-flush mb-3">
                        <%
                        count = 0;
                        for (Application app : applicationList) {
                            if (count >= 2) break;
                        %>
                            <li class="list-group-item"><%= app.getJobTitle() %> - (<%= app.getStatus() %>)</li>
                        <%
                            count++;
                        }
                        %>
                    </ul>
                    <a href="Applications.jsp" class="btn btn-success w-100">View All Applications</a>
                </div>
            </div>
        </div>

        <!-- Interview Schedule -->
        <div class="col-md-6 col-lg-4">
            <div class="card shadow h-100">
                <div class="card-body">
                    <h5 class="card-title">Interview Schedule</h5>
                    <ul class="list-group list-group-flush mb-3">
                        <%
                        count = 0;
                        for (Interview interview : interviewList) {
                            if (count >= 2) break;
                        %>
                            <li class="list-group-item"><%= interview.getCompanyName() %> - <%= interview.getInterviewDate() %></li>
                        <%
                            count++;
                        }
                        %>
                    </ul>
                    <a href="interviews.jsp" class="btn btn-warning w-100">View All Interviews</a>
                </div>
            </div>
        </div>

    </div>

</div>

<!-- Bootstrap JS (optional but recommended) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
