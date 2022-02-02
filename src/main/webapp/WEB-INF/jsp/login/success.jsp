<html>

<body>
<!--this success page is mapped from the /loginSubmit method. the page routes to view the success.jsp file-->
<a href="/logout">Logout</a>
<!--this link is displayed on the webpage connected to the logout method, and within the logout method,
the link is re-directed to the login page-->
<h1>You have successfully logged in!</h1>

<h3>Hello! Your username is ${username} and your password is ${password}</h3>
<!--<h3>Logged In User is $loggedinusername</h3> session.addObject in the loginController-->
</body>
</html>