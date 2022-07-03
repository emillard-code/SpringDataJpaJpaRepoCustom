<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Main Page</title>
    </head>

    <body>

    <p>Add Programmer</p>
    <form action="addCoder">
        ID: <input type="text" name="id"><br>
        NAME: <input type="text" name="name"><br>
        LANGUAGE: <input type="text" name="progLanguage"><br>
        <input type="submit"><br>
    </form>

    <br><br>

    <p>Get Programmer By Id</p>
    <form action="getCoder">
        ID: <input type="text" name="id"><br>
        <input type="submit"><br>
    </form>

    </body>

</html>