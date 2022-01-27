package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;


@Controller
//the C in MVC
public class IndexController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    /* the / and /index are the web pages that we can view by including in our local
    host url. ex. localhost:8080/ or localhost:8080/index*/
    public ModelAndView index() throws Exception {
        //index is the String View name for the jsp file that will be viewed.
        //ModelAndView is not mapped to a string
        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        return response;
    }
    @RequestMapping(value = "/indexSubmit", method = RequestMethod.GET)
    public ModelAndView indexSubmit(ServletRequest request) throws Exception {
/*indexSubmit is the String View name for the jsp file that will be viewed.
Model is an object that stores values that need to be sent to the jsp file. Store in strings.*/
       String username = request.getParameter("username");
       //This string username is coming from the Username named "username" in the Index.jsp file
        String firstName = request.getParameter("firstName");
        //This string username is coming from the First Name named "firstName" in the Index.jsp file
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        System.out.println("username = " + username);
        //This prints out the input received in the username form on the webpage.
        //before we had sout("username = " + request.getParameter("username);
        //String username is defined as username from index, and used in the print out statement
        System.out.println("First Name = " + firstName);
        System.out.println("Email = " + email);
        System.out.println("birthdate = " + birthdate);
        ModelAndView response = new ModelAndView();
        response.addObject("username",username);
        response.addObject("firstName",firstName);
        response.addObject("email", email);
        response.addObject("birthdate", birthdate);
        /*response is the String name for the model object variable, this can be named anything. addObject adds a specific object
        from the object defined in index and makes it available to render in the indexSubmit page.
        now, the username and firstname inputted into the form, are available to display
        on indexSubmit page*/
        response.setViewName("indexSubmit");
        //this response view routes to a viewing a webpage named indexSubmit, rather than the index.
        //for this to route to indexSubmit, a jsp file must be created.

        return response;
    }
}
