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
<h3>Autorization</h3>
<form action="/login" method="post">
    Email: <input type="email" name="username" /><br><br>
    Password: <input type="password" name="password" /> <br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Sign in"/>
</form>
<br>
<a href="/registration">Sign up</a>
</body>
</html>