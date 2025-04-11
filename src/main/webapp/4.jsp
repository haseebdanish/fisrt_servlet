<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center> <table border="2" align="center">      <th>Exponent</th>      <th>2^Exponent</th>      <% for (int i=0; i<=10; i++) { //start for loop %>             <tr>                 <td><%= i%></td>                 <td><%= Math.pow(2, i) %></td>             </tr>      <% } //end for loop %> </table> </center>
</body>
</html>