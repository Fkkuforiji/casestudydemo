<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="include/header.jsp"/>

<a href="login">Login</a>
<h1>User Registration</h1>
<form method ="GET" action="/indexSubmit">
    Username <input type="text" name ="username">
    <br>
    <br>
    First Name <input type="text" name ="firstName">
    <br>
    <br>
    Email <input type = "email" name = "email">
    Birthday <input type ="date" name ="birthdate">
    Dropdown <select name ="dropdown">
    <option>Option 1</option>
    <option>Option 2</option>
    <option>Option 3</option>
</select>
    <br>
<button type ="submit">Submit</button>

</form>
<jsp:include page="include/footer.jsp"/>


<%--<h1>Register</h1>--%>
<%--<form method ="get" action ="/indexSubmit" name = "Register">--%>
<%--    Email <input type ="email" name ="email address">--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    First Name <input type="text" name ="firstName">--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    Password <input type="password" name="password">--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    Confirm Password <input type="password" name="password">--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    Date of Birth <input type="date" name="birthdate">--%>
<%--    <h2>Liked Genres</h2>--%>
<%--    <input type="checkbox" id="Genre1" name="Genre1" value="Young Adult"> Young Adult--%>
<%--    <input type="checkbox" id="Genre2" name="Genre2" value="Thriller"> Thriller--%>


<%--</form>--%>

