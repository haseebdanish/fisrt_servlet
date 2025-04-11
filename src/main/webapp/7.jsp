<html>
<head>
   <title>JSP Page</title>
</head>
<body>
<% if (Math.random() > 0.5) { %>
    <jsp:forward page="PowersOf2.jsp" />
<% } else { %>
    <jsp:forward page="SineTable.jsp" />
<% } %>
</body>
</html>
