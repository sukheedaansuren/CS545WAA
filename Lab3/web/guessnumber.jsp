<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guess the number</title>
    </head>
    <body>
        <h1>Guess the number!</h1>
        <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
        <form method=GET action=GuessnumberServlet>
            Number=<input type=text name=number pattern='\d'> <br>
            <input type=submit value='Guess'>
        </form>
    </body>
</html>
