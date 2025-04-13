
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import = "org.cms.model.Course" %>
<%
HttpSession oldsession=request.getSession(false);
    List<Course> courses = (List<Course>) session.getAttribute("xyz");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Course List</h2>
    <a href="add-course.jsp" class="btn btn-success mb-3">Add New Course</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Credits</th>
            
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% if (courses != null) {
            for (Course course : courses) {
        %>
        <tr>
            <td><%= course.getCid() %></td>
            <td><%= course.getCname() %></td>
            <td><%= course.getC_credits() %></td>
            
            <td>
                <a href="edit-student?id=<%= course.getCid() %>" class="btn btn-sm btn-primary">Edit</a>
                <a href="delete-student?id=<%= course.getCid() %>" class="btn btn-sm btn-danger">Delete</a>
            </td>
        </tr>
        <%  }
        } else {
        %>
        <tr><td colspan="5" class="text-center">No Courses found</td></tr>
        <% } %>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>