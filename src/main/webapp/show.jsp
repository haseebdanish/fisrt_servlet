<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
<%
	HttpSession oldsession= request.getSession(false);
	List<Student> fetchAllStudents = response.getWriter().println(fetched);
%>
</body>
</html>