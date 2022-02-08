<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--this tag goes on each JSP page, cannot be included in the header-->
<!--WHAT DOES JSTL DO?-->

<jsp:include page="../include/header.jsp" />
<form method = "GET" action = "/registerSubmit">
   <table cellpadding="5">
    <tr>
        <td>Email:</td>
        <td><input type ="text" name = "email" value = "${form.email}"></td>
    </tr>
       <tr>
           <td>First Name:</td>
           <td><input type ="text" name = "firstName" value = "${form.firstName}"></td>
           <!--when the $ {} values are used, the inputs remain on the registration form - january 31st
           23:42 recording 3-->
       </tr>
       <tr>
           <td>Last Name:</td>
           <td><input type ="text" name = "lastName" value = "${form.lastName}"></td>
       </tr>
       <tr>
           <td>Age:</td>
           <td><input type ="text" name = "age"value = "${form.age}"></td>
       </tr>
       <tr>
           <td>Password:</td>
           <td><input type ="text" name = "password"value = "${form.password}"></td>
       </tr>
       <tr>
           <td>Confirm Password:</td>
           <td><input type ="text" name = "confirmPassword"value = "${form.confirmPassword}"></td>
       </tr>
   </table>
    <button type = "submit">Submit</button>

</form>

<div> <!--Google JSTL for loop. January 31st recording 3, 44:00-->
<c:forEach var="message" items = "${form.errorMessages}" varStatus = "status">
    <!--creates a for loop for the errormessages, "if errors then add the errors to the page, if not, then do not display.
    form.errorMessages is from the List in the RegisterBean. We created a list first, then added the form getErrormessages in the Register
    Controller, then we add the form.errorMessages from the form bean to display-->
    <span style="color:red"> ${message}</span><br>
</c:forEach>
</div>

<jsp:include page="../include/footer.jsp" />