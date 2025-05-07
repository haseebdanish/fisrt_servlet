<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.cms.model.Application" %>

<html>
<head>
    <title>Job Applications</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }

        table {
            width: 100%;
            background-color: #ffffff;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #dddddd;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        h2 {
            color: #333;
        }
    </style>
</head>
<body>
    <h2>All Job Applications</h2>

    <%
        List<Application> applicationList = (List<Application>) request.getAttribute("applicationList");
        if (applicationList != null && !applicationList.isEmpty()) {
    %>
        <table>
            <tr>
                <th>Application ID</th>
                <th>Job Title</th>
                <th>Applicant Name</th>
                <th>Email</th>
                <th>Status</th>
            </tr>
            <%
                for (Application app : applicationList) {
            %>
                <tr>
                    <td><%= app.getId() %></td>
                    <td><%= app.getJobTitle() %></td>
                    <td><%= app.getCompanyName() %></td>
                    <td><%= app.getDateApplied() %></td>
                    <td><%= app.getStatus() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No applications found.</p>
    <%
        }
    %>
</body>
</html>
