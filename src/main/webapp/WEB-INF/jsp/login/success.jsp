<jsp:include page="../include/header.jsp" />

<!--this success page is mapped from the /loginSubmit method. the page routes to view the success.jsp file-->

<!--this link is displayed on the webpage connected to the logout method, and within the logout method,
the link is re-directed to the login page-->
<body>
<br>
You have successfully logged in!
<br>
Your username is ${usernameSessionKey} (session username)<br>
Logged In User is ${loggedinuser} (logged in name)<!--session.addObject in the loginController-->
</body>

<jsp:include page="../include/footer.jsp" />