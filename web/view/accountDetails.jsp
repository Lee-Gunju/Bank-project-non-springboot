<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Details</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Account Details</h1>
<%
    String accountHolderName = (String) request.getAttribute("accountHolderName");
    Double balance = (Double) request.getAttribute("balance");
%>
<p>Account Holder Name: <%= accountHolderName %></p>
<p>Balance: <%= balance %></p>
<a href="/view/index.jsp">Back to Account Creation</a>
</body>
</html>