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




<jsp:include page="../include/footer.jsp" />