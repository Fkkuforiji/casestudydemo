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
        String firstname = request.getParameter("firstName");
        //This string username is coming from the First Name named "firstName" in the Index.jsp file

        System.out.println("username = " + request.getParameter("username"));
        //This prints out the input received in the username form on the webpage
        System.out.println("First Name = " +request.getParameter("firstName"));

        ModelAndView response = new ModelAndView();
        response.setViewName("indexSubmit");
        //this response view routes to a viewing a webpage named indexSubmit, rather than the index.
        //for this to route to indexSubmit, a jsp file must be created.

        return response;
    }
}
