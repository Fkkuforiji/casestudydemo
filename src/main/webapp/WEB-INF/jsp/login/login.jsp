
<html>
<body>

    <form action="/loginSubmit">
    <!--<form method ="GET" action="/loginSubmit">
    ^^^ what I had before. QUESTION: Why is GET not needed here?
    Get is not needed here because I am not trying to display this information(normally)
    I'm just trying re-route to the LoginSubmit page once the correct credentials are entered.
    Form Action routes to a web page, the method describes HOW it will be sent-->
    <!--Get is needed here because I am trying to retrieve and store the information input
    It will route to the LoginSubmit page once the correct credentials are entered.
    Form Action routes to a web page, the method describes HOW it will be sent

    My url is named loginSubmit and so is my jsp file, but the action url here is pointed towards the url, NOT the jsp page name
    ex. if my loginSubmit jsp was named success, I would still route the using the loginSubmit -->

    Username <input type="text" name ="username">
    <br>
    <br>
    Password <input type="password" name ="password">
    <br>
    <br>
    <button type ="submit">Submit</button>
</form>
</body>
</html>