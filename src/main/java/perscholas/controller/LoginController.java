package perscholas.controller;

import com.sun.net.httpserver.Authenticator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

//create a login controller
//create a login.jsp page with a form that has username and password
//make the form submit to loginSubmit
//in the loginSubmit function check if the username is tom and the password is jerry
//if it is true then add tom to the session and go to the success view
//otherwise return the login view
//in the login method, check if the username tom is in the session and if so, return the success view

@Controller
//the C in MVC
    public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, ServletRequest session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        Object username = session.getAttribute("username");
        Object password = session.getAttribute("password");
        return response;

//        if ("Tom" == username)
            //need to check in Tom is in the session.

    }

        @RequestMapping(value ="/loginSubmit", method = RequestMethod.GET)
        public ModelAndView loginSubmit(HttpServletRequest request, ServletRequest session) throws Exception {
            ModelAndView response = new ModelAndView();
            response.setViewName("login/loginSubmit");

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            response.addObject("username", username);
            if (username == "Tom" && password == "Jerry"){
                session.setAttribute("username", username);
                System.out.println("username is: " + username + "and the password is " +password);
                response.setViewName("login/loginSubmit");
            } else {
                System.out.println("Username is not correct!");
                response.setViewName("login/login");
            }

            return response;
        }
}





