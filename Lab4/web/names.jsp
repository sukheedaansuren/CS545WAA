<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Names</title>
    </head>
    <body>
        
        <a href='AllNamesServlet'><input type=button value='Show all names'></a>
        <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></p>
        <br>
        <form method=POST action="/Lab4/AddNamesServlet">
            Key=<input type=text name=addKey>
            First Name=<input type=text name=fname required>
            Last Name=<input type=text name=lname required>
            <input type=submit value='Add'><br><br>
        </form>

        <form method=POST action=RemoveNamesServlet>
            Key=<input type=text name=removeKey>
            <input type=submit value='Remove'>
        </form>
    </body>
</html>
