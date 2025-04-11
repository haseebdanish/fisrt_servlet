<html>
<head>
   <title>Powers of 2</title>
</head>
<body>
<center>
<%! 
   int degrees[] = {0, 15, 30, 45, 60, 75, 90};
   double number;
   String result;
%>
<table border="2" align="center">
<tr><th>Degree</th><th>Sine Value</th></tr>
<% 
   for (int i = 0; i < degrees.length; i++) { 
       number = Math.sin(Math.toRadians(degrees[i]));
       result = String.format("%.2f", number);
%>
   <tr>
      <td><%= degrees[i] %></td>
      <td><%= result %></td>
   </tr>
<% } %>
</table>
</center>
</body>
</html>
