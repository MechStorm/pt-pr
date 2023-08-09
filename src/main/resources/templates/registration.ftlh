<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Library</title>
</head>
<body>
<h1>Library</h1>
<h3>Registration</h3>
<form action="/registration" method="post">
    User name: <input type="text" name="name" /><br><br>
    Email: <input type="email" name="email" /> <br><br>
    Phone number: <input type="text" name="phone" /><br><br>
    Password: <input type="password" name="password" /> <br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Registration"/>
</form>
<#if errUser??>
    <h2 style="color:red">${errUser}</h2>
</#if>
</body>
</html>