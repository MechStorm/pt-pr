<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${book.title}</title>
</head>
<body>
<h2>Book ${book.title}</h2>
<hr>
<ul>
    <#list images as image >
        <img src="/images/${image.id}" height="100px" alt="book_image"><br><br>
    </#list>
    <li>Description: ${book.description}</li>
    <li>Author: ${book.author}</li>
    <li>Year: ${book.year}</li>
    <li>Price: ${book.price}</li>
    <#if book.user.phoneNumber??>
        <li>Phone number: ${book.user.phoneNumber}</li>
        <#else>
        <li>User didn't add his phone number</li>
    </#if>

</ul>
<hr>
<div class="home">
    <p><a href="/">home</a></p>
</div>
</body>
</html>