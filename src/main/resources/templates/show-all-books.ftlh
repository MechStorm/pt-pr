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
<div class="home">
    <p><a href="/">home</a></p>
</div>
<h1>Global library</h1>
<hr>
<#if user.email??>
    <h3>User name: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Log out">
    </form>
<#else>
    <a href="/login">Log in</a>
</#if>

<hr>

<form action="/" method="get">
    Search book: <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>

<#list allBooks as book>
    <ul class="books-list">
        <li class="books-list--item">
            <b>${book.title}</b> ${book.price} RUB. | <a href="/book/${book.id}">More</a>
        </li>
    </ul>
<#else>
    <h3>Books not found</h3>
</#list>
<#if user.email??>
    <hr>
    <h2>Add new book</h2>
    <form class="form-add" action="/book/add" method="post" enctype="multipart/form-data">
        Book title<input type="text" name="title"><br><br>
        Book description<input type="text" name="description"><br><br>
        Book author<input type="text" name="author"><br><br>
        Book year<input type="text" name="year"><br><br>
        Book price<input type="text" name="price"><br><br>
        First photo<input type="file" name="file1"><br><br>
        Second photo<input type="file" name="file2"><br><br>
        Third photo<input type="file" name="file3"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="ADD BOOK">
    </form>
</#if>
</body>
</html>