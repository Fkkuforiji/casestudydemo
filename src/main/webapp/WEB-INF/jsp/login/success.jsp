<html>


<!--this success page is mapped from the /loginSubmit method. the page routes to view the success.jsp file-->
<a href="/logout">Logout</a>
<!--this link is displayed on the webpage connected to the logout method, and within the logout method,
the link is re-directed to the login page-->
<br>
You have successfully logged in!
<br>
Your username is ${usernameSessionKey} (session user name)<br>
Logged In User is ${loggedinuser} (logged in name)<!--session.addObject in the loginController-->


</html>