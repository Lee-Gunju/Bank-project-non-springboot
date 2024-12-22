<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Creation</title>
</head>
<body>
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
