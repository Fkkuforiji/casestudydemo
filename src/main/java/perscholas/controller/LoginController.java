package perscholas.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.Form.LoginBean;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
//the C in MVC
public class LoginController {
//create a login controller
//create a login.jsp page with a form that has username and password
//make the form submit to loginSubmit
//in the loginSubmit function check if the username is tom and the password is jerry
//if it is true then add tom to the session and go to the loginSubmit view
//otherwise return the login view
//in the login method, check if the username tom is in the session and if so, return the  view
//do not worry about using POST - use GET on the form
//GOAL - have the correct URL showing for the correct page
//the form submission is invisible to the user (it does not show up in the browser url

//Test 1: go to /login when the user has not been logged in
//login and submit
//make sure the url is on the /success page

//Test 2: click logout and make sure you go to the /login page
//make sure /login is in the url

//Test 3: go to /success and make sure you are redirected to the /login page

//Test 4: login with failed credentials and go back to the /login page again

//Test 5: login with tom and jerry which will be on the success page and /success in url
//type/login in login and make sure you are redirected to /success and show the success page.

    private static String SESSION_KEY = "usernameSessionKey";
    private static String SESSION_KEY2 = "passwordSessionKey";
    //class recording January 27th, 3:18:00
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute(SESSION_KEY);
        String password = (String) session.getAttribute(SESSION_KEY2);

        //We are checking if a string exists in the current session
        if (StringUtils.equals(username, "Tom")) {
            response.setViewName("redirect:/success");
        } else {
            response.setViewName("login/login");
        }
        return response;

    }

    @RequestMapping(value = "/loginSubmit", method = RequestMethod.GET)
    //is the value mapping what tells the login.jsp file what method to read? A bit confused on the
    //connection of the jsp. Why is the yellow text loginSubmit, but we route to success.jsp
    //is this just a naming convention?
    public ModelAndView loginSubmit(HttpServletRequest request, HttpSession session, @RequestParam String username, @RequestParam String password) throws Exception {
        //REQUESTPARAM is the best way to requestParameters in a method
        ModelAndView response = new ModelAndView();
//      String username = request.getParameter("username");//this can also just be username, it says from ,so we know what we're taking from
        //String password = request.getParameter("password");
//^^ Using @RequestParam fulfills the need for the ^^ request.getParameter functions. I have both a username RequestParam and password RequestParam bc I need to request both.
        /* On GitHUB:
         * if (StringUtils.equals(username, "Tom") -- this is comparing the users input in the login page
         * to the if statement parameters. If the use inputs "Tom", then the input passes.*/
         if (StringUtils.equals(username, "Tom") && StringUtils.equals(password, "Jerry")) {
        //if ("Tom".equals(username) && "Jerry".equals(password)) {
            //^^another method of checking if an input matching the string in the equals parameter,
            // both are valid and do the same thing!
            session.setAttribute(SESSION_KEY, username);
            session.setAttribute(SESSION_KEY2, password);
            //QUESTION: in gitHUB the set attribute was "usernameSessionKey, WHY? can this just be username?
            // ^^QUESTION: Why is this included?
            System.out.println("The username is: " + username + " and the password is " + password);
            response.setViewName("redirect:/success");
            //when using redirect, use the URL of the controller method that you want displayed./success is the url in the success method
            //when using the name of a view, we use the path to the name of the jsp folder ex. /login(folder)/login
            /*^^ this is checking to see if the username and password equal Tom
             * and Jerry respectively. If both inputs are correct, then it goes to the
             * loginSubmit page (success jps in Eric H. github*/
        } else {
            //if the login is invalid
            session.setAttribute(SESSION_KEY, null);
            session.setAttribute(SESSION_KEY2, null);
                /* we set the attribute to null if the incorrect username is entered so that
                the incorrect username is not saved within the session
                 */
            System.out.println("Username is not correct!");
            response.setViewName("redirect:/login"); //--displays login in the url instead of loginSubmit
            //response.setViewName("login/login") -- this routed to the loginSubmit method
            //which gave the view of the loginSubmit in the url, but showed the login page.
        }

        return response;
            /*QUESTION: in the IndexSubmit method we needed to addObject but in this LoginSubmit method, we don't...it still displays in the
             success.jsp. Why do we need add object? Does it create permanence in the session?*/
    }

    //LOGIN BEAN EXAMPLE
//    @RequestMapping(value = "/loginSubmit2", method = RequestMethod.GET)
//
  //public ModelAndView LoginBean(HttpSession session, LoginBean form) throws Exception {
//        ModelAndView response = new ModelAndView();
      // you can also do:
//    String username = form.getUsername();
////    String password = form.getPassword();
      //^^ This simply renames the form.get attribute and you can use username & password in place of the form.get attribute in the if statement
//
//        if (StringUtils.equals(form.getUsername(), "Tom") && StringUtils.equals(form.getPassword(), "Jerry")) {
//            session.setAttribute(SESSION_KEY, form.getUsername());
//            session.setAttribute(SESSION_KEY2, form.getPassword());
//            System.out.println("The username is: " + form.getUsername() + " and the password is " + password);
//            response.setViewName("redirect:/success");
//        } else {
//            //if the login is invalid
//            session.setAttribute(SESSION_KEY, null);
//            session.setAttribute(SESSION_KEY2, null);
//            System.out.println("Username is not correct!");
//            response.setViewName("redirect:/login");
//        }
//
//        return response;
//           }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute(SESSION_KEY);
        String password = (String) session.getAttribute(SESSION_KEY2);
        if (StringUtils.equals(username, "Tom") && StringUtils.equals(password, "Jerry")){
            response.addObject("loggedinuser", username);
            response.addObject("loggedinpassword", password);
            response.setViewName("login/success");
        } else {
            response.setViewName("redirect:/login");
        }
            return response;

        }

    @RequestMapping(value ="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) throws Exception {
        //HttpServletRequest request - why did we remove this from the logout method?
        session.invalidate();
        //session invalidate destroys the current user session. Always implement a logout method this way
        ModelAndView response = new ModelAndView();
       // response.setViewName("login/login");
            response.setViewName("redirect:/login");
        //redirect:/login is another way to direct back to the login page, by way of the logout method
            //redirect reroutes to the actual login page and shows /login in the url whereas
            //login/login displays logout in the url but shows the login page. Preferable to use redirect.
        return response;

        }
}





