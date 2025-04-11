<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Scanner" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP</title>
</head>
<body>
<% 
int a,b;
// Scanner sc = new Scanner(System.in);
// out.println("Enter two numbers: "+"<br>");
// a = sc.nextInt();
// b = sc.nextInt(); 

a = Integer.parseInt(request.getParameter("a").toString());
b = Integer.parseInt(request.getParameter("b").toString());
out.println();
out.print(a+b);
%>
</body>
</html>