<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Login User</title>
</head>
<body>
<h1>Create Login User</h1>
<% if (request.getParameter("error") != null) { %>
<p style="color: red;">
    <% if ("user_exists".equals(request.getParameter("error"))) { %>
    계정이 이미 존재합니다.
    <% } else if ("creation_failed".equals(request.getParameter("error"))) { %>
    계정 생성에 실패했습니다.
    <% } %>
</p>
<% } %>
<form action="/createLoginUser" method="post">
    <label for="newUsername">Username:</label>
    <input type="text" id="newUsername" name="username" required>
    <br>
    <label for="newPassword">Password:</label>
    <input type="password" id="newPassword" name="password" required>
    <br>
    <button type="submit">Create User</button>
</form>
<a href="/view/login.jsp">Back to Login</a>
</body>
</html>