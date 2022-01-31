<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>Login page</head>
<body>
<form action="/loginSubmit">
    <!--<form method ="GET" action="/loginSubmit">
    ^^^ what I had before. Get is not needed here because I am not trying to display this information(normally)
    I'm just trying re-route to the LoginSubmit page once the correct credentials are entered.
    Form Action routes to a web page, the method describes HOW it will be sent-->

    Username <input type="text" name ="username">
    <br>
    <br>
    Password <input type="text" name ="password">
    <br>
    <br>
    <button type ="submit">Submit</button>
</form>
</body>
</html>