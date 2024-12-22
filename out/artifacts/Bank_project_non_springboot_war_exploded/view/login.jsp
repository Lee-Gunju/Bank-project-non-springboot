<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h1>Login</h1>
<%
  String success = request.getParameter("success");
  String error = request.getParameter("error");
  if (success != null || error != null) {
%>
<p style="color: <%= success != null ? "green" : "red" %>;">
  <% if ("user_created".equals(success)) { %>
  계정이 생성되었습니다. 로그인하세요.
  <% } else if ("username_not_found".equals(error)) { %>
  계정을 확인해주시거나, 새로운 계정을 만들어주세요!
  <% } else if ("incorrect_password".equals(error)) { %>
  패스워드를 다시 입력해주세요.
  <% } %>
</p>
<% } %>
<form action="/login" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required>
  <br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <button type="submit">Login</button>
</form>
<a href="/view/createUser.jsp">Create a new user</a>
</body>
</html>