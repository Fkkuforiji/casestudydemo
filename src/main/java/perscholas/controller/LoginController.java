package perscholas.controller;

import com.sun.net.httpserver.Authenticator;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//create a login controller
//create a login.jsp page with a form that has username and password
//make the form submit to loginSubmit
//in the loginSubmit function check if the username is tom and the password is jerry
//if it is true then add tom to the session and go to the loginSubmit view
//otherwise return the login view
//in the login method, check if the username tom is in the session and if so, return the  view

@Controller
//the C in MVC
    public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        //Object username = session.getAttribute("username");
        //QUESTION: Why do we not use -Object username = session.getAttribute instead?
        //Object password = session.getAttribute("password");

        String username = (String) session.getAttribute("usernameSessionKey");
        String password = (String) session.getAttribute("passwordfromLoginForm");
        //We are checking if a string exists in the current session
        if (StringUtils.equals(username, "Tom") && StringUtils.equals(password, "Jerry")){
            response.setViewName("/login/success");
           // response.addObject("loggedinUser", username);
            //QUESTION: What is the purpose of addObject here? The username still shows up without add object
            } else {
            response.setViewName("/login/login");
        }
            return response;

    }

        @RequestMapping(value ="/loginSubmit", method = RequestMethod.GET)
        //is the value mapping what tells the login.jsp file what method to read? A bit confused on the
        //connection of the jsps. Why is the yellow text loginSubmit, but we route to success.jsp
        //is this just a naming convention?
        public ModelAndView loginSubmit(HttpServletRequest request, HttpSession session) throws Exception {
           //QUESTION: is it ^^ supposed to be loginSubmit or success?
            ModelAndView response = new ModelAndView();
//            response.setViewName("login/success");
//^^ remove this view Name bc we only want to see this page if the IF statement below is successful
            String username = request.getParameter("usernamefromLoginForm");//this can also just be username, it says from so we know what we're taking from
            String password = request.getParameter("passwordfromLoginForm");

            /* On GitHUB:
             * if (StringUtils.equals(username, "Tom") -- this is comparing the users input in the login page
             * to the if statement parameters. If the use inputs "Tom", then the input passes.
             * EX. if (StringUtils.equal(username, "Tom") && StringUtils.equal(password, "Jerry")*/
            if ("Tom".equals(username) && "Jerry".equals(password)) {
                //^^another method of checking if an input matching the string in the equals parameter,
                // both are valid and do the same thing!
                session.setAttribute("usernameSessionKey", username);
                //QUESTION: in gitHUB the set attribute was "usernameSessionKey, WHY? can this just be username?
               // response.addObject("loggedinusername", username);
               // ^^QUESTION: Why is this included?
                System.out.println("The username is: " + username + " and the password is " + password);
                response.setViewName("login/success");
                /*^^ this is checking to see if the username and password equal Tom
                 * and Jerry respectively. If both inputs are correct, then it goes to the
                 * loginSubmit page (success jps in Eric H. github*/

            } else {
                //if the login is invalid
                session.setAttribute("usernamefromLoginForm", null);
                /* we set the attribute to null if the incorrect username is entered so that
                the incorrect username is not saved within the session
                 */
                System.out.println("Username is not correct!");
                response.setViewName("login/login");
            }

            return response;
            /*QUESTION: in the IndexSubmit method we needed to addObject but in this LoginSubmit method, we don't...it still displays in the
             success.jsp. Why do we need add object? Does it create permanence in the session?*/
        }
        @RequestMapping(value ="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpSession session) throws Exception {
        session.invalidate();
        //session invalidate destroys the current user session. Always implement a logout method this way
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        //redirect:/login is another way to direct back to the login page, by way of the logout method
        return response;

        }
}





