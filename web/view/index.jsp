<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Creation</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<% if (request.getParameter("error") != null) { %>
<p style="color: red;">
    <% if ("user_not_found".equals(request.getParameter("error"))) { %>
    해당 유저는 존재하지 않습니다!
    <% } else { %>
    오류가 발생했습니다. 다시 시도해주세요.
    <% } %>
</p>
<% } else if (request.getParameter("success") != null) { %>
<p style="color: green;">
    <% if ("balance_updated".equals(request.getParameter("success"))) { %>
    잔액이 업데이트되었습니다.
    <% } %>
</p>
<% } %>
<h1>Create a New Account</h1>
<form action="/createAccount" method="post">
    <label for="newAccountHolderName">Account Holder Name:</label>
    <input type="text" id="newAccountHolderName" name="accountHolderName" required>
    <br>
    <label for="initialBalance">Initial Balance:</label>
    <input type="number" id="initialBalance" name="initialBalance" required>
    <br>
    <button type="submit">Submit</button>
</form>

<h1>View Account Details</h1>
<form action="/createAccount" method="get">
    <label for="searchAccountHolderName">Account Holder Name:</label>
    <input type="text" id="searchAccountHolderName" name="accountHolderName" required>
    <br>
    <button type="submit">View Details</button>
</form>
</body>
</html>
