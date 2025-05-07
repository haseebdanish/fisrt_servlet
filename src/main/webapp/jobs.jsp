<%@ page import="java.util.List" %>
<%@ page import="org.cms.model.Job" %>
<%@ page import="DOA.JobDOA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Jobs</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }
        h2 { text-align: center; }
        .job-container { width: 80%; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 10px; }
        .job { border-bottom: 1px solid #ccc; padding: 10px 0; }
        .job:last-child { border-bottom: none; }
        .job-title { font-size: 1.2em; font-weight: bold; }
        .job-desc { margin-top: 5px; }
    </style>
</head>
<body>
    <h2>Available Job Openings</h2>

    <div class="job-container">
        <%
            try {
            	JobDOA jobDAO = new JobDOA();
                List<Job> jobs = JobDOA.getAvailableJobs();
                if (jobs.isEmpty()) {
        %>
                    <p>No job postings available at the moment.</p>
        <%
                } else {
                    for (Job job : jobs) {
        %>
                        <div class="job">
                            <div class="job-title"><%= job.getTitle() %></div>
                            <div class="job-desc"><%= job.getJobDescription() %></div>
                            <div>Location: <%= job.getLocation() %></div>
                        </div>
        <%
                    }
                }
            } catch (Exception e) {
                out.println("<p>Error loading jobs: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        %>
    </div>
</body>
</html>
