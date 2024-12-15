<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required>
  <br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <button type="submit">Login</button>
</form>

<h1>Create Login User</h1>
<form action="createLoginUser" method="post">
  <label for="newUsername">Username:</label>
  <input type="text" id="newUsername" name="username" required>
  <br>
  <label for="newPassword">Password:</label>
  <input type="password" id="newPassword" name="password" required>
  <br>
  <button type="submit">Create Account</button>
</form>
</body>
</html>